package com.amande.infrastructure.query.paint.list;

import com.amande.application.query.paint.list.PaintListQueryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PaintListQueryServiceImpl implements PaintListQueryService {
  @NonNull PaintListQueryMapper mapper;
  @Override
  @Transactional
  public Output query(Input input) {

    Output output;
    try(var results = mapper.select()) {
      output = StreamSupport.stream(results.spliterator(), false)
        .map(record -> new Output.Paint(
          record.id,
          record.colorName,
          record.colorCode
        ))
        .collect(collectingAndThen(toList(), Output::new));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return output;
  }
}
