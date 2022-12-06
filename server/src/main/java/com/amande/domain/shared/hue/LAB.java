package com.amande.domain.shared.hue;

public record LAB(
  L l,
  A a,
  B b
) {
  record L(double value) {
  }

  record A(double value) {
  }

  record B(double value) {
  }
}
