package com.example.amande.domain.models;

public class PaintId {
    
    private Integer value;

    public PaintId(int value) {

        this.value = value;

    }

    @Override
    public String toString() {

        return this.value.toString();
        
    }
    
}
