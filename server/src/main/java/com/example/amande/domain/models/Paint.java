package com.example.amande.domain.models;

import lombok.NonNull;

public record Paint(
  @NonNull PaintId id,
  @NonNull PaintName name,
  @NonNull PaintColorCode colorCode
) {}
