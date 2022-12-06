package com.amande.domain.shared.hue;

public class CIEDE2000 {

  /**
   * CIEDE2000で色差を計算する
   * <p>参考
   * <ul>
   *   <li><a href="https://ja.wikipedia.org/wiki/%E8%89%B2%E5%B7%AE">wiki</a>
   *
   * @param rgb1 比較元カラーコード
   * @param rgb2 比較先カラーコード
   * @return 色差
   */
  public static double calculation(RGB rgb1, RGB rgb2) {
    var lab1 = rgb1.toXYZ().toLAB();
    var lab2 = rgb2.toXYZ().toLAB();
    var dLp = Delta_L_Prime.calc(lab2.l(), lab1.l());
    var lb = L_Bar.calc(lab1.l(), lab2.l());
    var c1 = C.calc(lab1.a(), lab1.b());
    var c2 = C.calc(lab2.a(), lab2.b());
    var cb = C_Bar.calc(c1, c2);
    var ap1 = a_Prime.calc(lab1.a(), cb);
    var ap2 = a_Prime.calc(lab2.a(), cb);
    var cp1 = C_Prime.calc(lab1.a(), lab1.b());
    var cp2 = C_Prime.calc(lab2.a(), lab2.b());
    var cbp = C_Bar_Prime.calc(cp1, cp2);
    var dCp = Delta_C_Prime.calc(cp1, cp2);
    var hp1 = h_Prime.calc(lab1.b(), ap1);
    var hp2 = h_Prime.calc(lab2.b(), ap2);
    Delta_h_Prime dhp;
    H_Bar_Prime hbp;
    if (cp1.value() == 0 || cp2.value() == 0) {
      dhp = new Delta_h_Prime(0d);
      hbp = new H_Bar_Prime(hp1.value() + hp2.value());
    } else {
      dhp = Delta_h_Prime.calc(hp1, hp2);
      hbp = H_Bar_Prime.calc(hp1, hp2);
    }
    var dHp = Delta_H_Prime.calc(cp1, cp2, dhp);
    var t = T.calc(hbp);
    var sl = SL.calc(lb);
    var sc = SC.calc(cbp);
    var sh = SH.calc(cbp, t);
    var rt = RT.calc(cbp, hbp);
    var dE00 = Delta_E00.calc(dLp, sl, dCp, sc, dHp, sh, rt);
    return dE00.value();
  }

  record Delta_L_Prime(double value) {
    static Delta_L_Prime calc(LAB.L l1, LAB.L l2) {
      return new Delta_L_Prime(l1.value() - l2.value());
    }
  }

  record C(double value) {
    static C calc(LAB.A a, LAB.B b) {
      return new C(
        Math.sqrt(Math.pow(a.value(), 2d) + Math.pow(b.value(), 2d))
      );
    }
  }

  record L_Bar(double value) {
    static L_Bar calc(LAB.L l1, LAB.L l2) {
      return new L_Bar((l1.value() + l2.value()) / 2d);
    }
  }

  record C_Bar(double value) {
    static C_Bar calc(C c1, C c2) {
      return new C_Bar((c1.value() + c2.value()) / 2d);
    }
  }

  record a_Prime(double value) {
    static a_Prime calc(LAB.A a, C_Bar cBar) {
      return new a_Prime(
        a.value() + (a.value() / 2d) *
          (
            1 - Math.sqrt(
              Math.pow(cBar.value(), 7d) / (Math.pow(cBar.value(), 7d) + Math.pow(25d, 7d))
            )
          )
      );
    }
  }

  record C_Prime(double value) {
    static C_Prime calc(LAB.A a, LAB.B b) {
      return new C_Prime(
        Math.sqrt(
          Math.pow(a.value(), 2d) + Math.pow(b.value(), 2d)
        )
      );
    }
  }

  record C_Bar_Prime(double value) {
    static C_Bar_Prime calc(C_Prime cp1, C_Prime cp2) {
      return new C_Bar_Prime(
        (cp1.value() - cp2.value()) / 2d
      );
    }
  }

  record Delta_C_Prime(double value) {
    static Delta_C_Prime calc(C_Prime cp1, C_Prime cp2) {
      return new Delta_C_Prime(
        cp2.value() - cp1.value()
      );
    }
  }

  record h_Prime(double value) {
    static h_Prime calc(LAB.B b, a_Prime ap) {
      if (b.value() == 0 && ap.value() == 0)
        return new h_Prime(0d);
      var hp = Math.atan2(b.value(), ap.value());
      if (hp < 0)
        hp = hp + degreeToRadian(360d);
      return new h_Prime(hp);
    }
  }

  record Delta_h_Prime(double value) {
    static Delta_h_Prime calc(h_Prime hp1, h_Prime hp2) {
      if (Math.abs(hp1.value() - hp2.value()) <= degreeToRadian(180d))
        return new Delta_h_Prime(hp1.value() - hp2.value());
      if (hp1.value() <= hp2.value())
        return new Delta_h_Prime(hp1.value() - hp2.value() + degreeToRadian(360d));
      return new Delta_h_Prime(hp1.value() - hp2.value() - degreeToRadian(360d));
    }
  }

  record H_Bar_Prime(double value) {
    static H_Bar_Prime calc(h_Prime hp1, h_Prime hp2) {
      if (Math.abs(hp1.value() - hp2.value()) <= degreeToRadian(180d))
        return new H_Bar_Prime(
          (hp1.value() + hp2.value()) / 2d
        );
      if (hp1.value() <= hp2.value())
        return new H_Bar_Prime(
          (hp1.value() + hp2.value() + degreeToRadian(360d)) / 2d
        );
      return new H_Bar_Prime(
        (hp1.value() + hp2.value() - degreeToRadian(360d)) / 2d
      );
    }
  }

  record Delta_H_Prime(double value) {
    static Delta_H_Prime calc(C_Prime cp1, C_Prime cp2, Delta_h_Prime dhp) {
      return new Delta_H_Prime(
        2d * Math.sqrt(cp1.value() * cp2.value()) * Math.sin(dhp.value() / 2d)
      );
    }
  }

  record T(double value) {
    static T calc(H_Bar_Prime hp) {
      return new T(
        1 -
          0.17d * Math.cos(hp.value() - degreeToRadian(30d)) +
          0.24d * Math.cos(2d * hp.value()) +
          0.32d * Math.cos(3d * hp.value() + degreeToRadian(6d)) -
          0.20d * Math.cos(4d * hp.value() + degreeToRadian(63d))
      );
    }
  }

  record SL(double value) {
    static SL calc(L_Bar lb) {
      return new SL(
        1d +
          0.015d * Math.pow(lb.value() - 50d, 2d) / Math.sqrt(20d + Math.pow(lb.value() - 50d, 2d))
      );
    }
  }

  record SC(double value) {
    static SC calc(C_Bar_Prime cbp) {
      return new SC(1d + 0.045d * cbp.value());
    }
  }

  record SH(double value) {
    static SH calc(C_Bar_Prime cbp, T t) {
      return new SH(1d + 0.015d * cbp.value() * t.value());
    }
  }

  record RT(double value) {
    static RT calc(C_Bar_Prime cbp, H_Bar_Prime hbp) {
      return new RT(
        -2d *
          Math.sqrt(
            Math.pow(cbp.value(), 7d) / (Math.pow(cbp.value(), 7d) + Math.pow(25d, 7d))
          ) *
          Math.sin(
            60d * Math.exp(
              -Math.pow((hbp.value() - degreeToRadian(275d)) / degreeToRadian(25d), 2d)
            )
          )
      );
    }
  }

  record Delta_E00(double value) {
    static final double kl = 1d;
    static final double kc = 1d;
    static final double kh = 1d;

    static Delta_E00 calc(
      Delta_L_Prime dLp,
      SL sl,
      Delta_C_Prime dCp,
      SC sc,
      Delta_H_Prime dHp,
      SH sh,
      RT rt
    ) {
      return new Delta_E00(
        Math.sqrt(
          Math.pow(dLp.value() / (kl * sl.value()), 2d) +
            Math.pow(dCp.value() / (kc * sc.value()), 2d) +
            Math.pow(dHp.value() / (kh * sh.value()), 2d) +
            rt.value() * (dCp.value() / (kc * sc.value())) * (dHp.value() / (kh * sh.value()))
        )
      );
    }
  }

  static double degreeToRadian(double degree) {
    return degree * (Math.PI / 180d);
  }
}
