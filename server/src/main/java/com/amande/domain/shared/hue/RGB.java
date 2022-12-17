package com.amande.domain.shared.hue;

import lombok.NonNull;

import java.util.regex.Pattern;

public record RGB(
  R r,
  G g,
  B b
) {
  record R(double value) {}
  record G(double value) {}
  record B(double value) {}
  /**
   * XYZに変換する
   * <p>参考
   * <ul>
   *   <li><a href="https://en.wikipedia.org/wiki/SRGB#The_reverse_transformation">wiki</a>
   *   <li><a href="https://qiita.com/hachisukansw/items/09caabe6bec46a2a0858">qiita</a>
   */
  public XYZ toXYZ() {

    double r = this.r.value() / 255;
    double g = this.g.value() / 255;
    double b = this.b.value() / 255;

    r = r > 0.04045 ? Math.pow(((r + 0.055) / 1.055), 2.4) : (r / 12.92);
    g = g > 0.04045 ? Math.pow(((g + 0.055) / 1.055), 2.4) : (g / 12.92);
    b = b > 0.04045 ? Math.pow(((b + 0.055) / 1.055), 2.4) : (b / 12.92);

    double x = (r * 0.4124) + (g * 0.3576) + (b * 0.1805);
    double y = (r * 0.2126) + (g * 0.7152) + (b * 0.0722);
    double z = (r * 0.0193) + (g * 0.1192) + (b * 0.9505);

    return new XYZ(new XYZ.X(x), new XYZ.Y(y), new XYZ.Z(z));
  }

  public static RGB create(double r, double g, double b) {
    return new RGB(new R(r), new G(g), new B(b));
  }

  /**
   * 文字列(例:"rgb(255, 255, 255)")からRGBを生成します
   *
   * @param rgb 文字列
   * @return RGB
   */
  public static RGB createByString(@NonNull String rgb) {
    if (
      !Pattern
        .compile("^rgb\\( ?\\d{1,3} ?, ?\\d{1,3} ?, ?\\d{1,3} ?\\)$")
        .matcher(rgb)
        .find()
    )
      throw new IllegalArgumentException("RGB文字列形式が不正です");
    var rgbMatcher = Pattern
      .compile("(?<=[(, ])\\d{1,3}")
      .matcher(rgb);
    var r = rgbMatcher.find() ? Integer.parseInt(rgbMatcher.group()) : 0;
    var g = rgbMatcher.find() ? Integer.parseInt(rgbMatcher.group()) : 0;
    var b = rgbMatcher.find() ? Integer.parseInt(rgbMatcher.group()) : 0;
    return new RGB(new R(r), new G(g), new B(b));
  }
}
