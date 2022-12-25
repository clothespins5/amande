package com.amande.application.polling;

import com.amande.application.projection.paint.PaintProjector;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class PaintProjectionPoller {

  PaintProjector projector;

  @Scheduled(
    fixedDelay = 1000,
    initialDelay = 1000
  )
  public void init() {
    projector.project();
  }
}
