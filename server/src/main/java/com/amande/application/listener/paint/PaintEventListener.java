package com.amande.application.listener.paint;

import com.amande.application.projector.paint.PaintProjector;
import com.amande.domain.models.paint.PaintEvent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PaintEventListener {

  @NonNull PaintProjector projector;

  @EventListener
  public void onCreate(PaintEvent.Created event) {
    System.out.println("Create: " + event);
    projector.project();
  }

  @EventListener
  public void onChangeName(PaintEvent.NameChanged event) {
    System.out.println("ChangeName: " + event);
    projector.project();
  }

  @EventListener
  public void onChangeColorCode(PaintEvent.ColorCodeChanged event) {
    System.out.println("ChangeColorCode: " + event);
    projector.project();
  }
}
