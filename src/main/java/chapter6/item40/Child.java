package chapter6.item40;

public class Child implements Parent {

    /**
     * 인터페이스도 Default 메서드가 생겼기 때문에
     * 명확하게 @Override를 붙여서 실수할 소지를 줄이자
     */
    @Override
    public void print() {
        System.out.println("Child");
    }

    public static void main(String[] args) {
        Parent parent = new Child();
        parent.print();
    }
}

interface Parent {
    default void print() {
        System.out.println("Parent");
    }
}
