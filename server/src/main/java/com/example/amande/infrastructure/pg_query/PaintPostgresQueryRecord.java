package com.example.amande.infrastructure.pg_query;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class PaintPostgresQueryRecord {
  Integer id;
  Integer productnumber;
  String colorname;
  String colorcode;
}
