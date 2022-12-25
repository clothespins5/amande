package com.amande.infrastructure.repository.paint;

import com.amande.domain.event.EventStream;
import com.amande.domain.models.paint.Paint;
import com.amande.domain.models.paint.PaintEvent;
import com.amande.domain.models.paint.PaintID;
import com.amande.domain.models.paint.PaintRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Repository
public class PaintRepositoryImpl implements PaintRepository {

  PaintRepositoryMapper paintRepositoryMapper;
  ObjectMapper objectMapper;

  public Optional<Paint> findBy(PaintID id) {
    var eventStream = paintRepositoryMapper
      .selectEvents(id.value())
      .stream()
      .map(record -> {
        try {
          return objectMapper.readValue(
            record.jsonData(),
            PaintEvent.eventTypeToClass.get(record.eventType)
          );
        } catch (JsonProcessingException e) {
          throw new RuntimeException(e);
        }
      })
      .collect(collectingAndThen(toList(), EventStream::create));
    if (eventStream.events().isEmpty())
      return Optional.empty();
    return Optional.of(Paint.reconstruct(eventStream));
  }

  @Override
  public void save(Paint paint) {
    var eventRecords = paint
      .eventStream()
      .events()
      .stream()
      .map(event ->
        {
          try {
            return new PaintEventRecord(
              paint.id().value(),
              event.version(),
              event.eventType(),
              objectMapper.writeValueAsString(event)
            );
          } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
          }
        }
      )
      .toList();
    paintRepositoryMapper.insertEvent(eventRecords);
    paintRepositoryMapper.upsertAggregate(paint.id().value(), paint.eventStream().version());
  }
}
