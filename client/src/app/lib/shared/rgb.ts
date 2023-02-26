export class RGB {
  constructor(
    public readonly r: number,
    public readonly g: number,
    public readonly b: number
  ) {
  }

  public toString(): string {
    return `rgb(${this.r}, ${this.g}, ${this.b})`;
  }
}
