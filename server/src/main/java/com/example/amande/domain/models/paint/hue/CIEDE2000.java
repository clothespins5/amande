package com.example.amande.domain.models.paint.hue;

import com.example.amande.domain.models.paint.PaintColorCode;

import java.util.function.Function;

public class CIEDE2000 {

  public static double calculation(PaintColorCode source, PaintColorCode destination) {
    return CIEDE2000.calculation(
      source.rgb().toXYZ().toLAB(),
      destination.rgb().toXYZ().toLAB(),
      1,
      1,
      1
    );
  }

  /**
   * 参考:<a href="https://qiita.com/hachisukansw/items/860f061a2ab7a4f2d06f">...</a>
   */
  public static double calculation(LAB source, LAB destination, int kL, int kC, int kH) {

    Function<Double, Double> radianToDegree = (radian) -> radian * (180d / Math.PI);
    Function<Double, Double> degreeToRadian = (degree) -> degree * (Math.PI / 180d);

    double deltaLp = destination.l() - source.l();
    double l = (source.l() + destination.l()) / 2;
    double c1 = Math.sqrt(Math.pow(source.a(), 2) + Math.pow(source.b(), 2));
    double c2 = Math.sqrt(Math.pow(destination.a(), 2) + Math.pow(destination.b(), 2));
    double c = (c1 + c2) / 2;
    double v = 1 - Math.sqrt(Math.pow(c, 7) / (Math.pow(c, 7) + Math.pow(25, 7)));
    double ap1 = source.a() + (source.a() / 2d) *
      v;
    double ap2 = destination.a() + (destination.a() / 2d) *
      v;
    double cp1 = Math.sqrt(Math.pow(ap1, 2) + Math.pow(source.b(), 2));
    double cp2 = Math.sqrt(Math.pow(ap2, 2) + Math.pow(destination.b(), 2));
    double cp = (cp1 + cp2) / 2d;
    double deltaCp = cp2 - cp1;

    double hp1;
    if (source.b() == 0 && ap1 == 0) {
      hp1 = 0;
    } else {
      hp1 = radianToDegree.apply(Math.atan2(source.b(), ap1));
      if (hp1 < 0) {
        hp1 = hp1 + 360;
      }
    }
    double hp2;
    if (destination.b() == 0 && ap2 == 0) {
      hp2 = 0;
    } else {
      hp2 = radianToDegree.apply(Math.atan2(destination.b(), ap2));
      if (hp2 < 0) {
        hp2 = hp2 + 360;
      }
    }

    double deltahp;
    if (c1 == 0 || c2 == 0) {
      deltahp = 0;
    } else if (Math.abs(hp1 - hp2) <= 180) {
      deltahp = hp2 - hp1;
    } else if (hp2 <= hp1) {
      deltahp = hp2 - hp1 + 360;
    } else {
      deltahp = hp2 - hp1 - 360;
    }

    double deltaHp = 2 * Math.sqrt(cp1 * cp2) * Math.sin(degreeToRadian.apply(deltahp) / 2d);

    double Hp_;
    if (Math.abs(hp1 - hp2) > 180) {
      Hp_ = (hp1 + hp2 + 360) / 2d;
    } else {
      Hp_ = (hp1 + hp2) / 2d;
    }

    double T = 1 -
      0.17d * Math.cos(degreeToRadian.apply(Hp_ - 30)) +
      0.24d * Math.cos(degreeToRadian.apply(2 * Hp_)) +
      0.32d * Math.cos(degreeToRadian.apply(3 * Hp_ + 6)) -
      0.20d * Math.cos(degreeToRadian.apply(4 * Hp_ - 63));

    double SL = 1 + (
      (0.015d * Math.pow(l - 50, 2)) /
        Math.sqrt(20 + Math.pow(l - 50, 2))
    );
    double SC = 1 + 0.045d * cp;
    double SH = 1 + 0.015d * cp * T;

    double RT = -2 *
      Math.sqrt(
        Math.pow(cp, 7) /
          (Math.pow(cp, 7) + Math.pow(25, 7))
      ) *
      Math.sin(degreeToRadian.apply(
        60d * Math.exp(-Math.pow((Hp_ - 275) / 25, 2))
      ));

    return Math.sqrt(
      Math.pow(deltaLp / (kL * SL), 2) +
        Math.pow(deltaCp / (kC * SC), 2) +
        Math.pow(deltaHp / (kH * SH), 2) +
        RT * (deltaCp / (kC * SC)) * (deltaHp / (kH * SH))
    );
  }
}
