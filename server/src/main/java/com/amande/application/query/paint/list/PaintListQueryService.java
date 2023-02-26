package com.amande.application.query.paint.list;

import java.util.List;

public interface PaintListQueryService {

  Output query(Input input);

  record Input() {}

  record Output(
    List<Paint> results
  ) {

    public record Paint(
      String id,
      String name,
      String colorCode
    ) {}
  }
}
