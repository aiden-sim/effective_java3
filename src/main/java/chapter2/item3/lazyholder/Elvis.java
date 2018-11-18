package chapter2.item3.lazyholder;

public class Elvis {
    private Elvis() {
    }

    public static Elvis getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final Elvis INSTANCE = new Elvis();
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
    public static void main(String[] args) {
        Elvis elvis = Elvis.getInstance();
        // 참조하는 순간 초기화
        elvis.leaveTheBuilding();
    }
}
