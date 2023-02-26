package com.amande.domain.models.paint;

import com.amande.domain.shared.event.DomainEvent;
import com.amande.domain.shared.hue.RGB;

import java.util.Map;

public sealed interface PaintEvent extends DomainEvent {
  record Created(
    Integer version,
    PaintID id,
    PaintName name,
    RGB colorCode
  ) implements PaintEvent {
    public static String EVENT_TYPE = "PaintEvent.Created.V1";
    @Override
    public String eventType() {
      return EVENT_TYPE;
    }
  }

  record NameChanged(
    Integer version,
    PaintName name
  ) implements PaintEvent {
    public static String EVENT_TYPE = "PaintEvent.NameChanged.V1";
    @Override
    public String eventType() {
      return EVENT_TYPE;
    }
  }

  record ColorCodeChanged(
    Integer version,
    RGB colorCode
  ) implements PaintEvent {
    public static String EVENT_TYPE = "PaintEvent.ColorCodeChanged.V1";
    @Override
    public String eventType() {
      return EVENT_TYPE;
    }
  }

  Map<String, Class<? extends PaintEvent>> eventTypeToClass =
    Map.of(
      Created.EVENT_TYPE, Created.class,
      NameChanged.EVENT_TYPE, NameChanged.class,
      ColorCodeChanged.EVENT_TYPE, ColorCodeChanged.class
    );

}
