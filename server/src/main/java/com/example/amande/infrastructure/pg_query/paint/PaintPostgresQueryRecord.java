package com.example.amande.infrastructure.pg_query.paint;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class PaintPostgresQueryRecord {
  Integer id;
  String productNumber;
  String colorName;
  String colorCode;
}
