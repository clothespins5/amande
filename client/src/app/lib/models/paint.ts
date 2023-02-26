export class PaintID {
  constructor(public readonly value: string) {}
}

export class PaintName {
  constructor(public readonly value: string) {}
}

export class ColorCode {
  constructor(public readonly value: string) {}
}

export class Paint {
  constructor(
    public id: PaintID,
    public paintName: PaintName,
    public colorCode: ColorCode,
  ) {}

  changePaintName(paintName: PaintName): Paint {
    return new Paint(
      this.id,
      paintName,
      this.colorCode,
    )
  }
  changeColorCode(colorCode: ColorCode): Paint {
    return new Paint(
      this.id,
      this.paintName,
      colorCode,
    )
  }

}
