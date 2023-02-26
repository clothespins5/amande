package com.amande.infrastructure.projection.paint;

public record PaintRecord(
  String id,
  Integer lastVersion,
  String colorName,
  String colorCode
) {
}
