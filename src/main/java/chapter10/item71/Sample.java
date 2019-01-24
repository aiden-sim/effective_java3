package chapter10.item71;

public class Sample {
    public static void main(String[] args) {
        Sample obj = new Sample();

        // 검사 예외를 던지는 메서드 - 리펙터링 전
        try {
            obj.action(args);
        } catch (TheCheckedException e) {
            // 예외 상황에 대처
        }

        // 리팩토링 후 (여러 스레드가 동시에 접근할 수 있거나 외부 요인에 의해 상태가 변하면 이 리팩토링 적절못함)
        if (obj.actionPermitted(args)) {
            obj.action2(args);
        } else {
            throw new NullPointerException();
        }
    }

    public void action(Object args) throws TheCheckedException {
        if (args == null) throw new TheCheckedException();
    }

    public void action2(Object args) {
        // 로직 처리
    }

    public boolean actionPermitted(Object args) {
        return args != null;
    }
}