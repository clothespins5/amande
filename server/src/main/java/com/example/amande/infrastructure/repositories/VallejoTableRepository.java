package com.example.amande.infrastructure.repositories;

import com.example.amande.domain.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VallejoTableRepository implements IVallejoTableRepository {

  @Autowired
  private PostgreSql postgreSql;

  public Paints findAll() {

    List<Paint> paints = new ArrayList<>();

    try {

      ResultSet resultSet = postgreSql.executeQuery("SELECT * FROM vallejocolors");

      while (resultSet.next()) {

        Paint paint = new Paint(
          new PaintId(resultSet.getInt("id")),
          new PaintName(resultSet.getString("colorname")),
          new PaintColorCode.Builder()
            .specifiedColor(resultSet.getString("colorcode"))
            .buildOrElseThrow(builder -> new IllegalArgumentException())

        );
        paints.add(paint);

      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return new Paints(paints);
  }
}
