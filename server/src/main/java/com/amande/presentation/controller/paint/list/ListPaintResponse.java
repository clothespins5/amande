package com.amande.presentation.controller.paint.list;

import java.util.List;

public record ListPaintResponse(
  List<Paint> results
) {

  public record Paint(
    String paintID,
    String paintName,
    String colorCode
  ) {}
}
