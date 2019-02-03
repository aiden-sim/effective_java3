package chapter2.item3.field;

public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
        if (INSTANCE != null) {
            throw new RuntimeException("중복 생성");
        }
    }

    //  인스턴스 통제를 위한 readResolve
    private Object readResolve() {
        return INSTANCE;
    }

    // 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
    }
}
