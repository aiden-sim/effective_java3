package chapter3.item13;

public class C {
    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A("심준보", 33);
        //A a2 = (A) a.clone(); // protected 이기 때문에 에러난다.
    }
}
