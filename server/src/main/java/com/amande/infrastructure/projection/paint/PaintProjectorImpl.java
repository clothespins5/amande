package com.amande.infrastructure.projection.paint;

import com.amande.application.projection.paint.PaintProjector;
import com.amande.domain.models.paint.PaintID;
import com.amande.domain.models.paint.PaintRepository;
import com.amande.infrastructure.query.paint.PaintQueryMapper;
import com.amande.infrastructure.query.paint.PaintQueryRecord;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PaintProjectorImpl implements PaintProjector {

  PaintRepository repository;
  PaintQueryMapper queryMapper;
  PaintProjectionMapper projectionMapper;

  @Override
  public void project() {
    var updateTargets = projectionMapper.searchForUpdateTargets();
    if (updateTargets.isEmpty())
      return;
    var queryRecords = updateTargets
      .stream()
      .map(aggregateId -> repository.findBy(new PaintID(aggregateId)).orElseThrow())
      .map(paint ->
        new PaintQueryRecord(
          paint.id().value(),
          paint.eventStream().version(),
          paint.name().value(),
          paint.colorCode().toString()
        )
      )
      .toList();
    queryMapper.upsert(queryRecords);
  }
}
