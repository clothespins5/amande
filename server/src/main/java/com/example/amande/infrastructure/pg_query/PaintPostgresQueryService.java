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

  PostgreSql postgreSql;

  public PaintQueryResult nearPaints(PaintQueryInput input) {

    List<Paint> paints = new ArrayList<>();

    try {

      ResultSet resultSet = postgreSql.executeQuery("SELECT * FROM vallejocolors");

      while (resultSet.next()) {

        Paint paint = Paint.reconstruct(
          new PaintID(resultSet.getInt("id")),
          new PaintName(resultSet.getString("colorname")),
          PaintColorCode.from(resultSet.getString("colorcode"))
        );
        paints.add(paint.calculateColorProximity(PaintColorCode.from(input.colorCode())));

      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return paints
      .stream()
      .map(paint -> new PaintQueryResultItem(
        paint.name().value(),
        paint.colorCode().toString(),
        paint.colorProximity().value()
      ))
      .sorted(Comparator.comparing(PaintQueryResultItem::near).reversed())
      .limit(input.limit())
      .collect(Collectors.collectingAndThen(Collectors.toList(), PaintQueryResult::new));
  }

}
