package com.amande.application.command.paint.create;

import com.amande.domain.models.paint.Paint;
import com.amande.domain.models.paint.PaintName;
import com.amande.domain.models.paint.PaintRepository;
import com.amande.domain.shared.hue.RGB;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PaintCreateService {

  PaintRepository repository;

  @Transactional
  public Output create(Input input) {
    var paint = Paint.create(
      new PaintName(input.paintName),
      RGB.createFromString(input.colorCode)
    );

    repository.save(paint);

    return new Output(
      paint.id().value(),
      paint.name().value(),
      paint.colorCode().toString()
    );
  }

  public record Input(
    String paintName,
    String colorCode
  ) {}

  public record Output(
    String id,
    String name,
    String colorCode
  ) {}

}
