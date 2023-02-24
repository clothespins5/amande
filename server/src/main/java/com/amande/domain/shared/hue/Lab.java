package com.amande.domain.shared.hue;

public record Lab(
  L l,
  a a,
  b b
) {
  record L(double value) {
  }

  record a(double value) {
  }

  record b(double value) {
  }
}
