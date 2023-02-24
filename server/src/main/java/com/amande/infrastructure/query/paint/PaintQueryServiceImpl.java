package com.amande.infrastructure.query.paint;

import com.amande.application.query.paint.PaintQueryInput;
import com.amande.application.query.paint.PaintQueryOutput;
import com.amande.application.query.paint.PaintQueryService;
import com.amande.domain.shared.hue.CIEDE2000;
import com.amande.domain.shared.hue.RGB;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Comparator;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PaintQueryServiceImpl implements PaintQueryService {

  @NonNull PaintQueryMapper mapper;

  @Transactional
  public PaintQueryOutput query(PaintQueryInput input) {
    var sourceRgb = RGB.createByString(input.rgb());
    PaintQueryOutput output;
    try (var results = mapper.selectAll()) {
      output = StreamSupport.stream(results.spliterator(), false)
        .map(record -> new PaintQueryOutput.Paint(
          record.colorName(),
          record.colorCode(),
          CIEDE2000.calculateFromRGB(sourceRgb, RGB.createByString(record.colorCode))
        ))
        .sorted(Comparator.comparing(PaintQueryOutput.Paint::colorDifference))
        .limit(input.limit())
        .collect(collectingAndThen(toList(), PaintQueryOutput::new));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return output;
  }

}
