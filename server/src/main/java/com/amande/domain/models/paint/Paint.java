package com.amande.domain.models.paint;

import com.amande.domain.shared.event.DomainEvent;
import com.amande.domain.shared.event.DomainEventPublisher;
import com.amande.domain.shared.event.EventStream;
import com.amande.domain.shared.hue.RGB;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PRIVATE)
@Accessors(fluent = true)
@Value
public class Paint {

  EventStream eventStream;

  PaintID id;
  PaintName name;
  RGB colorCode;

  public static Paint reconstruct(@NonNull EventStream eventStream) {
    if (eventStream.events().isEmpty())
      throw new IllegalArgumentException("cannot reconstruct if events are empty");
    Paint paint = null;
    for (var event : eventStream.events())
      paint = handleEvent(paint, event);
    return new Paint(
      EventStream.createEventStreamFromVersion(paint.eventStream.version()),
      paint.id(),
      paint.name(),
      paint.colorCode()
    );
  }

  private static Paint handleEvent(Paint paint, DomainEvent event) {
    if (event instanceof PaintEvent.Created created)
      return Factory.create(created);
    if (event instanceof PaintEvent.NameChanged nameChanged)
      return Factory.create(paint, nameChanged);
    if (event instanceof PaintEvent.ColorCodeChanged colorCodeChanged)
      return Factory.create(paint, colorCodeChanged);
    throw new AssertionError();
  }

  public static Paint create(
    @NonNull PaintName name,
    @NonNull RGB colorCode
  ) {
    var createEvent = new PaintEvent.Created(
      EventStream.createEmptyStream().nextVersion(),
      PaintID.generate(),
      name,
      colorCode
    );
    DomainEventPublisher.publish(createEvent);
    return Factory.create(createEvent);
  }

  public void changeNameAndSave(
    @NonNull PaintName name,
    @NonNull PaintRepository repository
  ) {
    var event = new PaintEvent.NameChanged(
      eventStream().nextVersion(),
      name
    );
    var paint = handleEvent(this, event);
    repository.save(paint);
    DomainEventPublisher.publish(event);
  }

  public Paint changeColorCode(@NonNull RGB colorCode) {
    var changeColorCode = new PaintEvent.ColorCodeChanged(
      eventStream().nextVersion(),
      colorCode
    );
    DomainEventPublisher.publish(changeColorCode);
    return handleEvent(this, changeColorCode);
  }


  private static class Factory {

    static Paint create(PaintEvent.Created event) {
      return new Paint(
        EventStream.createEmptyStream().append(event),
        event.id(),
        event.name(),
        event.colorCode()
      );
    }

    static Paint create(Paint paint, PaintEvent.NameChanged event) {
      return new Paint(
        paint.eventStream().append(event),
        paint.id(),
        event.name(),
        paint.colorCode()
      );
    }

    static Paint create(Paint paint, PaintEvent.ColorCodeChanged event) {
      return new Paint(
        paint.eventStream().append(event),
        paint.id(),
        paint.name(),
        event.colorCode()
      );
    }
  }


}
