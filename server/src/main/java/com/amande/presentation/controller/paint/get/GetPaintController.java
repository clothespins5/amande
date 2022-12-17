package com.amande.presentation.controller.paint.get;

import com.amande.application.query.paint.PaintQueryInput;
import com.amande.application.query.paint.PaintQueryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GetPaintController {

  @NonNull PaintQueryService service;

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/paints")
  public GetPaintResponse get(@RequestParam String rgb, @RequestParam int limit) {
    return service
      .query(new PaintQueryInput(rgb, limit))
      .results()
      .stream()
      .map(item -> new GetPaintResponse.Paint(
        item.name(),
        item.colorCode(),
        item.colorDifference()
      ))
      .collect(collectingAndThen(toList(), GetPaintResponse::new));
  }
}
