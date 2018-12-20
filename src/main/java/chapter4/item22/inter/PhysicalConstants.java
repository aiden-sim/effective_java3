package chapter4.item22.inter;

/**
 * 사용 금지
 * 차라리 enum을 사용해라
 */
public interface PhysicalConstants {
    static final double AVOGADROS_NUMBER = 6.022_140_857e23;
    static final double BOLTZMANN_CONSTANT = 1.380_648_52e-23;
    static final double ELECTRON_MASS = 9.109_383_56e-31;

    // instance에 모든 멤버 변수는 public static final 이다.
    final double PI = 3.14; // public static 생략
    static int HEART = 10;  // public final 생략

    // instance에 모든 메서드는 public abstract 이다.
    String getCard(); // public abstract 생략

}
