package com.example.amande.domain.models;

public class PaintName {

    private String value;

    public PaintName(String value) {

        this.value = value;

    }

    @Override
    public String toString() {
        return this.value;
    }
}
