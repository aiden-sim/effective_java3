package chapter4.item24.staticmember;

/**
 * 정적 멤버 클래스
 */
public class Outer {
    int a = 10;
    private int b = 20;
    static int c = 30;

    private void outerPrint() {
        System.out.println("test");
    }

    static class Inner {
        static int d = 40; // static 변수 선언 가능

        public void print() {
            //outerPrint(); 접근 불가
            //System.out.println(a + " " + b + " " + c); Outer class에 static 변수 빼고 접근 불가
            System.out.println(c);
        }

        public static void staticPrint() {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        Outer.Inner inner = new Outer.Inner();
        inner.print();

        System.out.println(Outer.Inner.d); // static 변수에 대한 접근
        Outer.Inner.staticPrint();         // static 메서드에 대한 접근
    }
}
