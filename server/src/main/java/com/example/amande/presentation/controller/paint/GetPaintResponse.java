package com.example.amande.presentation.controller.paint;

public record GetPaintResponse(
  String name,
  String colorCode,
  Double colorProximity
) {}
