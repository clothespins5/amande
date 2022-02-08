package com.example.amande.domain.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VallejoTable {
    
    public final VallejoTableId id;

    public final List<Paint> paints;

    public VallejoTable(List<Paint> paints) {

        this.id = new VallejoTableId();
        this.paints = paints;
        
    }

    public List<PaintNear> nearPaints(String specifiedColorString) {

        PaintColorCode specifiedColorCode = PaintColorCode.create(specifiedColorString);
        List<PaintNear> nearPaints = new ArrayList<PaintNear>();

        for (Paint paint : paints) {

            double near = paint.colorCode.near(specifiedColorCode);
            PaintNear paintNear = new PaintNear(paint.id, near);
            nearPaints.add(paintNear);

        }

        nearPaints.sort(Comparator.comparing(PaintNear::getNear).reversed());

        return nearPaints;
    }
}
