package com.amande.domain.shared.event;

public interface DomainEvent {
  Integer version();
  String eventType();
}
