package com.amande.domain.shared.hue;

public record XYZ(
  X x,
  Y y,
  Z z
) {
  record X(double value) {}
  record Y(double value) {}
  record Z(double value) {}

  /**
   * LABに変換する
   * <p>参考
   * <ul>
   *   <li><a href="https://en.wikipedia.org/wiki/Lab_color_space#CIELAB-CIEXYZ_conversions">wiki</a>
   *   <li><a href="https://qiita.com/lookman/items/a0df0833d2ee07b8eccc">qiita</a>
   *
   */
  public Lab toLAB() {

    double x = this.x.value() * 100d / 95.047d;
    double y = this.y.value() * 100d / 100d;
    double z = this.z.value() * 100d / 108.883d;

    x = x > 0.008856d ? Math.pow(x, 1d / 3d) : (7.787037d * x) + 0.008856d;
    y = y > 0.008856d ? Math.pow(y, 1d / 3d) : (7.787037d * y) + 0.008856d;
    z = z > 0.008856d ? Math.pow(z, 1d / 3d) : (7.787037d * z) + 0.008856d;

    double l = (116 * y) - 16;
    double a = 500 * (x - y);
    double b = 200 * (y - z);

    return new Lab(
      new Lab.L(l / 100),
      new Lab.a(a / 100),
      new Lab.b(b / 100)
    );
  }
}
