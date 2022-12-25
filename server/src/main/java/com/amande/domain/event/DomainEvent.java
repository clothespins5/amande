package com.amande.domain.event;

public interface DomainEvent {
  Integer version();
  String eventType();
}
