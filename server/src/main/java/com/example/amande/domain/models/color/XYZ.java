package com.example.amande.domain.models.color;

public class XYZ {
    
    public double x;

    public double y;

    public double z;

    public XYZ(double[] xyz) {
        this.x = xyz[0];
        this.y = xyz[1];
        this.z = xyz[2];
    }

    public XYZ(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * 参考:https://qiita.com/lookman/items/a0df0833d2ee07b8eccc
     * @return
     */
    public LAB toLAB() {

        double x = this.x * 100d / 95.047d;
        double y = this.y * 100d / 100d;
        double z = this.z * 100d / 108.883d;

        x = x > 0.008856d ? Math.pow(x, 1d / 3d) : (7.787037d * x) + 0.008856d;
        y = y > 0.008856d ? Math.pow(y, 1d / 3d) : (7.787037d * y) + 0.008856d;
        z = z > 0.008856d ? Math.pow(z, 1d / 3d) : (7.787037d * z) + 0.008856d;
        
        double l = (116 * y) - 16;
        double a = 500 * (x - y);
        double b = 200 * (y - z);

        return new LAB(l / 100, a / 100, b / 100);


    }
}
