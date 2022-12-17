package com.amande.presentation.controller.paint.get;

import java.util.List;

public record GetPaintResponse(
  List<Paint> results
) {
  public record Paint(
    String name,
    String colorCode,
    Double colorProximity
  ) {}
}
