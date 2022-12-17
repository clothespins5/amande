package com.amande.domain.models.paint;

import com.amande.domain.event.DomainEvent;
import com.amande.domain.shared.hue.RGB;

public sealed interface PaintEvent {
  record Created(
    PaintID id,
    PaintName name,
    RGB colorCode
  ) implements PaintEvent, DomainEvent {}

  record NameChanged(
    PaintName name
  ) implements PaintEvent, DomainEvent {}

  record ColorCodeChanged(
    RGB colorCode
  ) implements PaintEvent, DomainEvent {}
}
