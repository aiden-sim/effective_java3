package chapter4.item24.member;

/**
 * 멤버 클래스(비정적)
 * Inner를 사용하기 위해서 반드시 Outer 클래스를 객체 생성해야 한다.
 */
public class Outer {
    int a = 10;
    private int b = 20;
    static int c = 30;

    private void outerPrint() {
        System.out.println("test");
    }

    // Outer Class 자원들 다 접근 가능
    // 정적 필드, 정적 메서드 선언 불가
    class Inner {
        public void print() {
            outerPrint();
            System.out.println(a + " " + b + " " + c);
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.print();
    }
}
