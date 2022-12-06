package com.amande.infrastructure.query.paint;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class PaintQueryRecord {
  Integer id;
  String productNumber;
  String colorName;
  String colorCode;
}
