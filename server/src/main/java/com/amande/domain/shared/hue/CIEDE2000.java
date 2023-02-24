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
  public static double calculateFromRGB(RGB rgb1, RGB rgb2) {
    var lab1 = rgb1.toXYZ().toLAB();
    var lab2 = rgb2.toXYZ().toLAB();
    return calculateFromLab(lab1, lab2);
  }

  public static double calculateFromLab(Lab lab1, Lab lab2) {
    var dLp = _Delta_L_Prime.calc(lab2.l(), lab1.l());
    var lb = _L_Bar.calc(lab1.l(), lab2.l());
    var c1 = _C.calc(lab1.a(), lab1.b());
    var c2 = _C.calc(lab2.a(), lab2.b());
    var cb = _C_Bar.calc(c1, c2);
    var ap1 = _a_Prime.calc(lab1.a(), cb);
    var ap2 = _a_Prime.calc(lab2.a(), cb);
    var cp1 = _C_Prime.calc(ap1, lab1.b());
    var cp2 = _C_Prime.calc(ap2, lab2.b());
    var cbp = _C_Bar_Prime.calc(cp1, cp2);
    var dCp = _Delta_C_Prime.calc(cp1, cp2);
    var hp1 = _h_Prime.calc(lab1.b(), ap1);
    var hp2 = _h_Prime.calc(lab2.b(), ap2);
    _Delta_h_Prime dhp;
    _H_Bar_Prime hbp;
    if (cp1.value() == 0 || cp2.value() == 0) {
      dhp = new _Delta_h_Prime(0d);
      hbp = new _H_Bar_Prime(hp1.value() + hp2.value());
    } else {
      dhp = _Delta_h_Prime.calc(hp1, hp2);
      hbp = _H_Bar_Prime.calc(hp1, hp2);
    }
    var dHp = _Delta_H_Prime.calc(cp1, cp2, dhp);
    var t = _T.calc(hbp);
    var sl = _SL.calc(lb);
    var sc = _SC.calc(cbp);
    var sh = _SH.calc(cbp, t);
    var rt = _RT.calc(cbp, hbp);
    var dE00 = _Delta_E00.calc(dLp, sl, dCp, sc, dHp, sh, rt);
    return dE00.value();
  }

  private record _Delta_L_Prime(double value) {
    static _Delta_L_Prime calc(Lab.L l1, Lab.L l2) {
      return new _Delta_L_Prime(l1.value() - l2.value());
    }
  }

  private record _C(double value) {
    static _C calc(Lab.a a, Lab.b b) {
      return new _C(
        Math.sqrt(Math.pow(a.value(), 2d) + Math.pow(b.value(), 2d))
      );
    }
  }

  private record _L_Bar(double value) {
    static _L_Bar calc(Lab.L l1, Lab.L l2) {
      return new _L_Bar((l1.value() + l2.value()) / 2d);
    }
  }

  private record _C_Bar(double value) {
    static _C_Bar calc(_C c1, _C c2) {
      return new _C_Bar((c1.value() + c2.value()) / 2d);
    }
  }

  private record _a_Prime(double value) {
    static _a_Prime calc(Lab.a a, _C_Bar cBar) {
      return new _a_Prime(
        a.value() + (a.value() / 2d) *
          (
            1 - Math.sqrt(
              Math.pow(cBar.value(), 7d) / (Math.pow(cBar.value(), 7d) + Math.pow(25d, 7d))
            )
          )
      );
    }
  }

  private record _C_Prime(double value) {
    static _C_Prime calc(_a_Prime ap, Lab.b b) {
      return new _C_Prime(
        Math.sqrt(
          Math.pow(ap.value(), 2d) + Math.pow(b.value(), 2d)
        )
      );
    }
  }

  private record _C_Bar_Prime(double value) {
    static _C_Bar_Prime calc(_C_Prime cp1, _C_Prime cp2) {
      return new _C_Bar_Prime(
        (cp1.value() + cp2.value()) / 2d
      );
    }
  }

  private record _Delta_C_Prime(double value) {
    static _Delta_C_Prime calc(_C_Prime cp1, _C_Prime cp2) {
      return new _Delta_C_Prime(
        cp2.value() - cp1.value()
      );
    }
  }

  private record _h_Prime(double value) {
    static _h_Prime calc(Lab.b b, _a_Prime ap) {
      if (b.value() == 0 && ap.value() == 0)
        return new _h_Prime(0d);
      var hp = Math.toDegrees(Math.atan2(b.value(), ap.value()));
      if (hp < 0)
        hp = hp + 360d;
      return new _h_Prime(hp);
    }
  }

  private record _Delta_h_Prime(double value) {
    static _Delta_h_Prime calc(_h_Prime hp1, _h_Prime hp2) {
      if (Math.abs(hp2.value() - hp1.value()) <= 180d)
        return new _Delta_h_Prime(hp2.value() - hp1.value());
      if (hp2.value() <= hp1.value())
        return new _Delta_h_Prime(hp2.value() - hp1.value() + 360d);
      return new _Delta_h_Prime(hp2.value() - hp1.value() - 360d);
    }
  }

  private record _H_Bar_Prime(double value) {
    static _H_Bar_Prime calc(_h_Prime hp1, _h_Prime hp2) {
      if (Math.abs(hp1.value() - hp2.value()) <= 180d)
        return new _H_Bar_Prime(
          (hp1.value() + hp2.value()) / 2d
        );
      if (hp1.value() <= hp2.value())
        return new _H_Bar_Prime(
          (hp1.value() + hp2.value() + 360d) / 2d
        );
      return new _H_Bar_Prime(
        (hp1.value() + hp2.value() - 360d) / 2d
      );
    }
  }

  private record _Delta_H_Prime(double value) {
    static _Delta_H_Prime calc(_C_Prime cp1, _C_Prime cp2, _Delta_h_Prime dhp) {
      return new _Delta_H_Prime(
        2d * Math.sqrt(cp1.value() * cp2.value()) * Math.sin(Math.toRadians(dhp.value() / 2d))
      );
    }
  }

  private record _T(double value) {
    static _T calc(_H_Bar_Prime hbp) {
      return new _T(
        1d -
          0.17d * Math.cos(Math.toRadians(hbp.value() - 30d)) +
          0.24d * Math.cos(Math.toRadians(2d * hbp.value())) +
          0.32d * Math.cos(Math.toRadians(3d * hbp.value() + 6d)) -
          0.20d * Math.cos(Math.toRadians(4d * hbp.value() - 63d))
      );
    }
  }

  private record _SL(double value) {
    static _SL calc(_L_Bar lb) {
      return new _SL(
        1d +
          0.015d * Math.pow(lb.value() - 50d, 2d) / Math.sqrt(20d + Math.pow(lb.value() - 50d, 2d))
      );
    }
  }

  private record _SC(double value) {
    static _SC calc(_C_Bar_Prime cbp) {
      return new _SC(1d + 0.045d * cbp.value());
    }
  }

  private record _SH(double value) {
    static _SH calc(_C_Bar_Prime cbp, _T t) {
      return new _SH(1d + 0.015d * cbp.value() * t.value());
    }
  }

  private record _RT(double value) {
    static _RT calc(_C_Bar_Prime cbp, _H_Bar_Prime hbp) {
      return new _RT(
        -2d *
          Math.sqrt(
            Math.pow(cbp.value(), 7d) / (Math.pow(cbp.value(), 7d) + Math.pow(25d, 7d))
          ) *
          Math.sin(
            Math.toRadians(
              60d * Math.exp(
                -Math.pow((hbp.value() - 275d) / 25d, 2d)
              )
            )
          )
      );
    }
  }

  private record _Delta_E00(double value) {
    static final double kl = 1d;
    static final double kc = 1d;
    static final double kh = 1d;

    static _Delta_E00 calc(
      _Delta_L_Prime dLp,
      _SL sl,
      _Delta_C_Prime dCp,
      _SC sc,
      _Delta_H_Prime dHp,
      _SH sh,
      _RT rt
    ) {
      return new _Delta_E00(
        Math.sqrt(
          Math.pow(dLp.value() / (kl * sl.value()), 2d) +
            Math.pow(dCp.value() / (kc * sc.value()), 2d) +
            Math.pow(dHp.value() / (kh * sh.value()), 2d) +
            rt.value() * (dCp.value() / (kc * sc.value())) * (dHp.value() / (kh * sh.value()))
        )
      );
    }
  }
}
