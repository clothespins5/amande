package com.example.amande.application.query.paint;

public record PaintQueryResultItem(
  String name,
  String colorCode,
  Double colorProximity
) {}
