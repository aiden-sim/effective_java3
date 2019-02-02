package chapter11.item83;

public class Sample {
    // 인스턴스 필드를 초기화하는 일반적인 방법
    private final FieldType field = computeFieldValue();

    // 지연 초기화
    private FieldType field2;

    private synchronized FieldType getField() {
        if (field2 == null) {
            field2 = computeFieldValue();
        }

        return field2;
    }

    FieldType computeFieldValue() {
        return new FieldType();
    }

    // 정적 필드용 지연 초기화 홀더 클래스 관용구
    private static class FieldHolder {
        static final FieldType field = computeFieldValue2();
    }

    public static FieldType computeFieldValue2() {
        return new FieldType();
    }

    private static FieldType getField2() {
        return FieldHolder.field;
    }

    // 인스턴스 필드 지연 초기화용 이중검사 관용구
    private volatile FieldType field3;

    private FieldType getField3() {
        FieldType result = field3;
        if (result != null) { // 첫 번째 검사 (락 사용 안 함)
            return result;
        }

        synchronized (this) {
            if (field3 == null) { // 두 번째 검사 (락 사용)
                field3 = computeFieldValue();
            }
            return field3;
        }
    }
}

class FieldType {
}

