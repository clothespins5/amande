package com.example.amande.domain.models.paint;

import com.example.amande.domain.models.paint.hue.RGB;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PRIVATE)
@Accessors(fluent = true)
@Value
public class PaintColorCode {

  RGB rgb;

  public static PaintColorCode from(String rgb) {
    Pattern rgbPattern = Pattern.compile("(?<=[(, ])\\d{1,3}");
    Matcher rgbMatcher = rgbPattern.matcher(rgb);
    rgbMatcher.find();
    int red = Integer.parseInt(rgbMatcher.group());
    rgbMatcher.find();
    int green = Integer.parseInt(rgbMatcher.group());
    rgbMatcher.find();
    int blue = Integer.parseInt(rgbMatcher.group());
    return new PaintColorCode(new RGB(red, green, blue));
  }

  @Override
  public String toString() {
    return this.rgb.toString();
  }
}
