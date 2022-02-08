package com.example.amande.domain.models;

public class PaintNear {
    
    public final PaintId id;

    private final double near;

    public PaintNear(PaintId id, double near) {

        this.id = id;
        this.near = near;

    }

    public double getNear() {
        return this.near;
    }
}
