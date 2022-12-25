package com.amande.domain.models.paint;

import com.amande.domain.event.DomainEvent;
import com.amande.domain.shared.hue.RGB;

public sealed interface PaintEvent extends DomainEvent {
  record Created(
    Integer version,
    PaintID id,
    PaintName name,
    RGB colorCode
  ) implements PaintEvent {}

  record NameChanged(
    Integer version,
    PaintName name
  ) implements PaintEvent {}

  record ColorCodeChanged(
    Integer version,
    RGB colorCode
  ) implements PaintEvent {}
  default String eventType() {
    if (this instanceof Created)
      return "PaintEvent.Created.V1";
    else if (this instanceof NameChanged)
      return "PaintEvent.NameChanged.V1";
    else if (this instanceof ColorCodeChanged)
      return "PaintEvent.ColorCodeChanged.V1";
    else throw new AssertionError();
  }

}
