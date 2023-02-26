package com.amande.presentation.controller.paint.update;

import com.amande.application.command.paint.update.PaintChangeNameService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PaintChangeNameController {

  @NonNull PaintChangeNameService service;

  @CrossOrigin(origins = "http://localhost:4200")
  @PatchMapping("/paints/change-name")
  public void patch(@RequestBody Request request) {
    service.changeName(
      new PaintChangeNameService.Input(
        request.id(),
        request.paintName()
      )
    );
  }

  public record Request(
    String id,
    String paintName
  ) {}

}
