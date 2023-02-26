package com.amande.presentation.controller.paint.list;

import com.amande.application.query.paint.list.PaintListQueryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ListPaintController {

  @NonNull PaintListQueryService service;

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/paints/list")
  public ListPaintResponse get() {
    return service
      .query(new PaintListQueryService.Input())
      .results()
      .stream()
      .map(item -> new ListPaintResponse.Paint(
        item.id(),
        item.name(),
        item.colorCode()
      ))
      .collect(collectingAndThen(toList(), ListPaintResponse::new));
  }
}
