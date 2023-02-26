package com.amande.presentation.controller.paint.create;

import com.amande.application.command.paint.create.PaintCreateService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreatePaintController {
  @NonNull PaintCreateService service;

  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping("/paints")
  public void post(@RequestBody Request request) {
    service.create(
      new PaintCreateService.Input(
        request.paintName(),
        request.colorCode()
      )
    );
  }

  public record Request(
    String paintName,
    String colorCode
  ) {}
}
