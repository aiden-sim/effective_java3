package chapter6.item40;

/**
 * 추상 클래스나 인터페이스에서는 상위 클래스나 상위 인터페이스의 메서드를
 * 재정의하는 모든 메서드에 @Override를 다는 것이 좋다.
 */
public interface InterfaceChild extends InterfaceParent {
    @Override
    void print();

    @Override
    default void print2() {

    }
}

interface InterfaceParent {
    void print();

    default void print2() {

    }
}
