package com.example.amande.domain.models;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.amande.domain.models.color.CIEDE2000;
import com.example.amande.domain.models.color.LAB;
import com.example.amande.domain.models.color.RGB;

public final class PaintColorCode {


    public static class Builder {

        private final String specifiedColor;
        private final String red;
        private final String green;
        private final String blue;

        public Builder() {
            this.specifiedColor = null;
            this.red = null;
            this.green = null;
            this.blue = null;
        }

        private Builder(String specifiedColor) {
            this.specifiedColor = specifiedColor;
            this.red = null;
            this.green = null;
            this.blue = null;
        }

        private Builder(String red, String green, String blue) {
            this.specifiedColor = null;
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        public Builder specifiedColor(String specifiedColor) {
            return new Builder(specifiedColor);
        }

        public Builder rgb(String red, String green, String blue) {
            return new Builder(red, green, blue);
        }

        public <X extends Throwable> PaintColorCode buildOrElseThrow(
                Function<Builder, X> exceptionFunction
        ) throws X {
            if (specifiedColor != null) {
                Pattern rgbPattern = Pattern.compile("(?<=\\(|,| )[0-9]{1,3}");
                Matcher rgbMatcher = rgbPattern.matcher(specifiedColor);
                if (rgbMatcher.matches())
                    throw exceptionFunction.apply(this);

                rgbMatcher.find();
                int red = Integer.parseInt(rgbMatcher.group());

                rgbMatcher.find();
                int green = Integer.parseInt(rgbMatcher.group());

                rgbMatcher.find();
                int blue = Integer.parseInt(rgbMatcher.group());
                RGB rgb = new RGB(red, green, blue);
                return new PaintColorCode(rgb);
            }
            if (red != null && green != null && blue != null) {
                RGB rgb = new RGB(
                        Integer.parseInt(red),
                        Integer.parseInt(green),
                        Integer.parseInt(blue)
                );
                return new PaintColorCode(rgb);
            }
            throw exceptionFunction.apply(this);
        }
    }

    private final RGB rgb;


    private PaintColorCode(RGB rgb) {

        this.rgb = rgb;
    }

    public double near(PaintColorCode paintColor) {

        LAB source = this.rgb.toXYZ().toLAB();

        LAB destination = paintColor.rgb.toXYZ().toLAB();

        return CIEDE2000.calculation(source, destination);

    }

    @Override
    public String toString() {

        return this.rgb.toString();

    }
}
