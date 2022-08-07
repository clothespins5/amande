package com.example.amande.usecase;

import java.util.ArrayList;
import java.util.List;

import com.example.amande.domain.models.Paint;
import com.example.amande.domain.models.PaintNear;

public class VallejoTableGetOutput {

    public final List<PaintGetOutput> paints;

    public static VallejoTableGetOutput create(List<Paint> paints, List<PaintNear> nearPaints) {

        List<PaintGetOutput> output = new ArrayList<>();

        for (PaintNear nearPaint: nearPaints) {

            Paint paint = paints.stream()
              .filter(searchPaint -> searchPaint.id().equals(nearPaint.id()))
              .findFirst()
              .orElseThrow();
            PaintGetOutput paintGetOutput = new PaintGetOutput(
                paint.name().toString(),
                paint.colorCode().toString(),
                nearPaint.near());
                
            output.add(paintGetOutput);
        }

        return new VallejoTableGetOutput(output);
    }

    private VallejoTableGetOutput(List<PaintGetOutput> paints) {

        this.paints = paints;

    }
}
