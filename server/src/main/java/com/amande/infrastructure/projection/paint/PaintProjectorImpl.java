package com.amande.infrastructure.projection.paint;

import com.amande.application.projector.paint.PaintProjector;
import com.amande.domain.models.paint.PaintID;
import com.amande.domain.models.paint.PaintRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class PaintProjectorImpl implements PaintProjector {

  PaintRepository repository;
  PaintProjectorMapper projectorMapper;

  @Override
  @Transactional
  public void project() {
    var updateTargets = projectorMapper.searchForUpdateTargets();
    if (updateTargets.isEmpty())
      return;
    var queryRecords = updateTargets
      .stream()
      .map(aggregateId -> repository.findBy(new PaintID(aggregateId)).orElseThrow())
      .map(paint ->
        new PaintRecord(
          paint.id().value(),
          paint.eventStream().version(),
          paint.name().value(),
          paint.colorCode().toString()
        )
      )
      .toList();
    projectorMapper.upsert(queryRecords);
  }
}
