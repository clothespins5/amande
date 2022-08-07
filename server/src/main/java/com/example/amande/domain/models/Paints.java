package com.example.amande.domain.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@EqualsAndHashCode
@ToString
@Getter
public class Paints {

    private final List<Paint> paints;

    public Paints(List<Paint> paints) {

        this.paints = paints;
        
    }

    public List<PaintNear> nearPaints(String specifiedColor) {

        PaintColorCode specifiedColorCode = new PaintColorCode.Builder()
                .specifiedColor(specifiedColor)
                .buildOrElseThrow(builder -> new IllegalArgumentException(builder.toString()));
        List<PaintNear> nearPaints = new ArrayList<>();

        for (Paint paint : paints) {

            double near = paint.colorCode().near(specifiedColorCode);
            PaintNear paintNear = new PaintNear(paint.id(), near);
            nearPaints.add(paintNear);

        }

        nearPaints.sort(Comparator.comparing(PaintNear::near));

        return nearPaints;
    }
}
