package com.amande.domain.shared.event;

import lombok.NonNull;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class DomainEventPublisher implements ApplicationEventPublisherAware {

  private static ApplicationEventPublisher publisher;
  @Override
  public void setApplicationEventPublisher(@NonNull ApplicationEventPublisher applicationEventPublisher) {
    publisher = applicationEventPublisher;
  }

  public static void publish(DomainEvent event) {
    publisher.publishEvent(event);
  }
}
