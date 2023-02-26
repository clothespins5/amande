package com.amande.application.query.paint.search;

import java.util.List;

public interface PaintSearchQueryService {
  Output query(Input input);

    record Input(
      String rgb,
      Integer limit
    ) {}

  record Output(
    List<Paint> results
  ) {

    public record Paint(
      String name,
      String colorCode,
      Double colorDifference
    ) {}
  }
}
