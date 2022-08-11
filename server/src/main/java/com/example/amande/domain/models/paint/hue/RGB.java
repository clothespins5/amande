package com.example.amande.domain.models.paint.hue;

public record RGB(
  double r,
  double g,
  double b
) {
  /**
   * 参考:<a href="https://qiita.com/hachisukansw/items/09caabe6bec46a2a0858">...</a>
   */
  public XYZ toXYZ() {

    double r = this.r / 255;
    double g = this.g / 255;
    double b = this.b / 255;

    r = r > 0.04045 ? Math.pow(((r + 0.055) / 1.055), 2.4) : (r / 12.92);
    g = g > 0.04045 ? Math.pow(((g + 0.055) / 1.055), 2.4) : (g / 12.92);
    b = b > 0.04045 ? Math.pow(((b + 0.055) / 1.055), 2.4) : (b / 12.92);

    double x = (r * 0.4124) + (g * 0.3576) + (b * 0.1805);
    double y = (r * 0.2126) + (g * 0.7152) + (b * 0.0722);
    double z = (r * 0.0193) + (g * 0.1192) + (b * 0.9505);

    return new XYZ(x, y, z);
  }
}
