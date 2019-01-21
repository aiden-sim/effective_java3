package chapter4.item24.staticmember;

/**
 * 정적 멤버 클래스
 */
public class Outer {
    int a = 10;
    private int b = 20;

    static class Inner {
        static int d = 40; // static 변수 선언 가능

        public void print() {
            Outer outer = new Outer();
            System.out.println(outer.a);
            System.out.println(outer.b);
        }
    }
}
