package com.example.amande.domain.models;

public class Paint {
    
    public final PaintId id;

    public final PaintName name;

    public final PaintColorCode colorCode;
        

    public Paint(PaintId id, PaintName name, PaintColorCode colorCode) {

        this.id = id;
        this.name = name;
        this.colorCode = colorCode;
        
    }
    
}
