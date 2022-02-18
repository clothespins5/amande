package com.example.amande.domain.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.example.amande.domain.models.color.CIEDE2000;
import com.example.amande.domain.models.color.LAB;
import com.example.amande.domain.models.color.RGB;

public class PaintColorCode {

    private final RGB rgb;

    /**
     * 
     * @param colorCode
     * @return
     */
    public static PaintColorCode create(String colorCode) {

        Pattern rgbPattern = Pattern.compile("(?<=\\(|,| )[0-9]{1,3}");
        Matcher rgbMatcher = rgbPattern.matcher(colorCode);

        rgbMatcher.find();
        String red = rgbMatcher.group();

        rgbMatcher.find();
        String green = rgbMatcher.group();

        rgbMatcher.find();
        String blue = rgbMatcher.group();
 
        return PaintColorCode.create(red, green, blue);

    }

    public static PaintColorCode create(String red, String green, String blue) {

        Integer r = Integer.parseInt(red);
        Integer g = Integer.parseInt(green);
        Integer b = Integer.parseInt(blue);
        RGB rgb = new RGB(r, g, b);
        
        return new PaintColorCode(rgb);

    }


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
