package com.amande.infrastructure.repository.paint;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class PaintRecord {
  Integer id;
  String productNumber;
  String colorName;
  String colorCode;
}
