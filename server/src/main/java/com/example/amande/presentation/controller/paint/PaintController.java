package com.example.amande.presentation.controller.paint;

import com.example.amande.application.query.paint.PaintQueryInput;
import com.example.amande.application.query.paint.PaintQueryResult;
import com.example.amande.application.query.paint.PaintQueryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PaintController {

  private PaintQueryService service;

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/vallejoTable")
  public PaintQueryResult getVallejoTable(@RequestParam String color, @RequestParam int limit) {

    PaintQueryInput input = new PaintQueryInput(color, limit);
    return service.nearPaints(input);
  }
}
