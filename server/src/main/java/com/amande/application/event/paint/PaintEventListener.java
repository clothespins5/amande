package com.amande.application.event.paint;

import com.amande.domain.models.paint.PaintEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PaintEventListener {

  @EventListener
  public void onCreate(PaintEvent.Created event) {
    System.out.println("Create: " + event);
  }

  @EventListener
  public void onChangeName(PaintEvent.NameChanged event) {
    System.out.println("ChangeName: " + event);
  }

  @EventListener
  public void onChangeColorCode(PaintEvent.ColorCodeChanged event) {
    System.out.println("ChangeColorCode: " + event);
  }
}
