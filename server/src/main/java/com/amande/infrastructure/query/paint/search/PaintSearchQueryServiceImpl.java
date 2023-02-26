package com.amande.infrastructure.query.paint.search;

import com.amande.application.query.paint.search.PaintSearchQueryService;
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
public class PaintSearchQueryServiceImpl implements PaintSearchQueryService {

  @NonNull PaintSearchQueryMapper mapper;

  @Transactional
  public Output query(Input input) {
    var sourceRgb = RGB.createFromString(input.rgb());
    Output output;
    try (var results = mapper.select()) {
      output = StreamSupport.stream(results.spliterator(), false)
        .map(record -> new Output.Paint(
          record.colorName(),
          record.colorCode(),
          CIEDE2000.calculateFromRGB(sourceRgb, RGB.createFromString(record.colorCode))
        ))
        .sorted(Comparator.comparing(Output.Paint::colorDifference))
        .limit(input.limit())
        .collect(collectingAndThen(toList(), Output::new));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return output;
  }

}
