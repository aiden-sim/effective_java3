package chapter5.item28;

public class Sample {
    public static void main(String[] args) {
        // 공변성
        B[] bArray = new B[10];
        A[] aArray = new A[10];
        aArray = bArray;
    }
}

class A {

}
class B extends A {

}
