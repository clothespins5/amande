package com.example.amande.infrastructure.pg_repository.paint;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class PaintPostgresRecord {
  Integer id;
  String productNumber;
  String colorName;
  String colorCode;
}
