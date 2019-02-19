package chapter6.Item39;

import java.util.ArrayList;
import java.util.List;

public class Sample2 {
    // 성공해야 한다.
    // by zero
    @ExceptionTest(ArithmeticException.class)
    public static void m1() {
        int i = 0;
        i = i / i;
    }

    // 실패해야 한다. (다른 예외 발생)
    // IndexOutOfBounds
    @ExceptionTest(ArithmeticException.class)
    public static void m2() {
        int[] a = new int[0];
        int i = a[1];
    }

    // 실패해야 한다. (예외가 발생하지 않음)
    @ExceptionTest(ArithmeticException.class)
    public static void m3() {

    }

    // 배열 매개변수를 받는 애너테이션을 사용하는 코드
    @ExceptionTest2({IndexOutOfBoundsException.class, NullPointerException.class})
    public static void doublyBad() {
        List<String> list = new ArrayList<>();
        // IndexOutOfBounds나 NullPointerException 발생
        list.addAll(5, null);
    }

    @ExceptionTest3(IndexOutOfBoundsException.class)
    @ExceptionTest3(NullPointerException.class)
    public static void doublyBad2() {
        List<String> list = new ArrayList<>();
        list.addAll(5, null);
    }
}
