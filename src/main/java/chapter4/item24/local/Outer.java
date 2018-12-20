package chapter4.item24.local;

/**
 * 로컬 클래스
 * 메서드 안에 정의되어 있기 때문에 로컬 변수 처럼 인식된다.
 * 메서드가 호출될 때 생성되며 메서드가 종료될 때 삭제된다.
 */
public class Outer {
    int a = 10;
    private int b = 20;
    static int c = 30;

    private void outerPrint() {
        int local = 40;
        System.out.println("test");
    }

    public void outerMethod() {
        class Inner {
            public void print() {
                outerPrint();
                System.out.println(a + " " + b + " " + c);
            }
        }

        // Inner 클래스의 객체생성은 outer 메서드내에서 한다.
        Inner i = new Inner();
        i.print();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.outerMethod();
    }
}
