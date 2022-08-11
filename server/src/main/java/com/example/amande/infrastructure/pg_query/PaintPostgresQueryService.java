package com.example.amande.infrastructure.pg_query;

import com.example.amande.application.query.paint.PaintQueryInput;
import com.example.amande.application.query.paint.PaintQueryResult;
import com.example.amande.application.query.paint.PaintQueryResultItem;
import com.example.amande.application.query.paint.PaintQueryService;
import com.example.amande.domain.models.paint.Paint;
import com.example.amande.domain.models.paint.PaintColorCode;
import com.example.amande.domain.models.paint.PaintID;
import com.example.amande.domain.models.paint.PaintName;
import com.example.amande.infrastructure.PostgreSql;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PaintPostgresQueryService implements PaintQueryService {

  private final PaintPostgresQueryMapper mapper;

  public PaintQueryResult nearPaints(PaintQueryInput input) {
    var paintColorCode = PaintColorCode.from(input.colorCode());
    return mapper.selectAll()
      .stream()
      .map(record -> Paint.reconstruct(
        new PaintID(record.id()),
        new PaintName(record.colorcode()),
        PaintColorCode.from(record.colorcode())
      ))
      .map(paint -> paint.calculateColorProximity(paintColorCode))
      .map(paint -> new PaintQueryResultItem(
        paint.name().value(),
        paint.colorCode().toString(),
        paint.colorProximity().value()
      ))
      .sorted(Comparator.comparing(PaintQueryResultItem::colorProximity).reversed())
      .limit(input.limit())
      .collect(Collectors.collectingAndThen(Collectors.toList(), PaintQueryResult::new));
  }

}
