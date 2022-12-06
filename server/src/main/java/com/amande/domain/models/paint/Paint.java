package com.amande.domain.models.paint;

import com.amande.domain.shared.hue.RGB;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PRIVATE)
@Accessors(fluent = true)
@Value
public class Paint {

  PaintID id;
  PaintName name;
  RGB colorCode;

  public static Paint reconstruct(
    @NonNull PaintID id,
    @NonNull PaintName name,
    @NonNull RGB colorCode
  ) {
    return new Paint(
      id,
      name,
      colorCode
    );
  }

}
