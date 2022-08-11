package com.example.amande.domain.models.paint;

import com.example.amande.domain.models.paint.hue.CIEDE2000;
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
  PaintColorCode colorCode;
  PaintColorProximity colorProximity;

  public static Paint reconstruct(
    @NonNull PaintID id,
    @NonNull PaintName name,
    @NonNull PaintColorCode colorCode
  ) {
    return new Paint(
      id,
      name,
      colorCode,
      new PaintColorProximity(0d)
    );
  }

  public Paint calculateColorProximity(PaintColorCode colorCode) {
    return new Paint(
      this.id,
      this.name,
      this.colorCode,
      new PaintColorProximity(CIEDE2000.calculation(this.colorCode, colorCode))
    );
  }
}
