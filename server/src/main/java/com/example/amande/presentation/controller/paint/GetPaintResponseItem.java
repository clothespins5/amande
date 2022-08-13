package com.example.amande.presentation.controller.paint;

public record GetPaintResponseItem(
  String name,
  String colorCode,
  Double colorProximity
) {}
