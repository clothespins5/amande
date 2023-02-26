package com.amande.domain.shared.event;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Value
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EventStream {
  Integer version;
  List<DomainEvent> events;

  public static EventStream create(List<DomainEvent> events) {
    return new EventStream(
      events.get(events.size() - 1).version(),
      events
    );
  }

  public static EventStream createEmptyStream() {
    return new EventStream(0, List.of());
  }

  public static EventStream createEventStreamFromVersion(Integer version) {
    return new EventStream(version, List.of());
  }

  public Integer nextVersion() {
    return version + 1;
  }
  public EventStream append(DomainEvent event) {
    var mutableList = new ArrayList<>(events);
    mutableList.add(event);
    return new EventStream(
      nextVersion(),
      Collections.unmodifiableList(mutableList)
    );
  }
}
