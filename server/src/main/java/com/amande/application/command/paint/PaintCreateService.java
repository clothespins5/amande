package com.amande.application.command.paint;

import com.amande.domain.models.paint.Paint;
import com.amande.domain.models.paint.PaintName;
import com.amande.domain.shared.hue.RGB;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaintCreateService {

  public Output create(Input input) {
    var paint = Paint.create(
      new PaintName(input.name),
      RGB.createByString(input.colorCode)
    );
    return new Output(
      paint.id().value(),
      paint.name().value(),
      paint.colorCode().toString()
    );
  }

  public record Input(
    String name,
    String colorCode
  ) {}

  public record Output(
    String id,
    String name,
    String colorCode
  ) {}

}
