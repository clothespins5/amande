package com.example.amande.domain.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public class PaintColorCode {

    private final Vector3D colorVector;

    private final String red;

    private final String green;

    private final String blue;

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

        Vector3D colorVector = new Vector3D(Double.parseDouble(red), Double.parseDouble(green), Double.parseDouble(blue));
        
        if (!Vector3D.ZERO.equals(colorVector)) {

            colorVector = colorVector.normalize();

        }

        return new PaintColorCode(colorVector, red, green, blue);

    }


    private PaintColorCode(Vector3D colorVector, String red, String green, String blue) {

        this.colorVector = colorVector;
        this.red = red;
        this.green = green;
        this.blue = blue;

    }

    public double near(PaintColorCode paintColor) {

        return this.colorVector.dotProduct(paintColor.colorVector);

    }

    @Override
    public String toString() {

        return "rgb(" + this.red + ", " + this.green + ", " + this.blue + ")";
        
    }
}
