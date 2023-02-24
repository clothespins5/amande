package com.amande.infrastructure.query.paint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class PaintQueryRecord {
  String id;
  Integer lastVersion;
  String colorName;
  String colorCode;
}