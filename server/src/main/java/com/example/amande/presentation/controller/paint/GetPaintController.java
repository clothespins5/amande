package com.example.amande.presentation.controller.paint;

import com.example.amande.application.query.paint.PaintQueryInput;
import com.example.amande.application.query.paint.PaintQueryResult;
import com.example.amande.application.query.paint.PaintQueryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class GetPaintController {

  private PaintQueryService service;

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/paints")
  public GetPaintResponse get(@RequestParam String rgb, @RequestParam int limit) {

    PaintQueryInput input = new PaintQueryInput(rgb, limit);
    PaintQueryResult result = service.get(input);
    return result.results()
      .stream()
      .map(item -> new GetPaintResponseItem(
        item.name(),
        item.colorCode(),
        item.colorProximity()
      ))
      .collect(Collectors.collectingAndThen(Collectors.toList(), GetPaintResponse::new));
  }
}
