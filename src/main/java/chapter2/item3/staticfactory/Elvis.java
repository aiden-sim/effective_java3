package chapter2.item3.staticfactory;

import java.io.Serializable;
import java.util.function.Supplier;

public class Elvis implements Serializable {
    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {
        if (INSTANCE != null) {
            throw new RuntimeException("중복 생성");
        }
    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    // 직렬화
    public Object readResolve() {
        return getInstance();
    }
    // 스레드별로 다른 인스턴스 생성 시. 전환 가능
    /*
    public static Elvis getInstance() {
        return new Elvis();
    }
    */

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
    public static void main(String[] args) {
        Elvis elvis = Elvis.getInstance();
        elvis.leaveTheBuilding();

        Supplier<Elvis> elvisSupplier = Elvis::getInstance;
    }
}


