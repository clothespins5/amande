package com.amande.domain.shared.hue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CIEDE2000Test {

  @Test
  void test() {
    System.out.println(
      CIEDE2000.calculation(
        RGB.create(255, 255, 255),
        RGB.create(0, 0, 0)
      )
    );
    System.out.println(
      CIEDE2000.calculation(
        RGB.create(255, 255, 255),
        RGB.create(255, 255, 255)
      )
    );
    System.out.println(
      CIEDE2000.calculation(
        RGB.create(255, 255, 255),
        RGB.create(243,243,232)
      )
    );
    System.out.println(
      CIEDE2000.calculation(
        RGB.create(255, 255, 255),
        RGB.create(245,245,223)
      )
    );
    System.out.println(
      CIEDE2000.calculation(
        RGB.create(255, 255, 255),
        RGB.create(252,240,217)
      )
    );
  }
}