package chapter1;

/**
 * Created by simjunbo on 2018-11-12.
 */
public class Sample {
    // 1) 멤버변수
    int iv = 10; // 인스턴스 변수
    static int cv = 10; // 클래수 변수 (전역 변수)

    // 2) 지역변수
    public void sample() {
        int lv = 10;
    }

    // 3) 메서드
    // 인스턴스 메서드
    public void instanceMethod() {

    }

    // 클래스 메서드
    public static void classMethod() {

    }

    // 4) 멤버 클래스
    // static인 멤버 클래스
    static class StaticInnerClass {

    }

    // static이 아닌 멤버 클래스
    class InnerClass {

    }
}
