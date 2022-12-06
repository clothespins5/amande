package com.amande.application.query.paint;

import java.util.List;

public record PaintQueryOutput(
  List<Paint> results
) {

  public record Paint(
    String name,
    String colorCode,
    Double colorDifference
  ) {}
}
