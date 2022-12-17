package com.amande.domain.models.paint;

import java.util.UUID;

public record PaintID(String value) {
  public static PaintID generate() {
    return new PaintID(UUID.randomUUID().toString());
  }
}
