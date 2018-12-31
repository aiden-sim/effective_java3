package chapter6.item34;

public class Sample {
    public static final int APPLE_FUJI = 0;
    public static final int APPLE_PIPPIN = 1;
    public static final int APPLE_GRANNY_SMITH = 2;

    public static final int ORANGE_NAVEL = 0;
    public static final int ORANGE_TEMPLE = 1;
    public static final int ORANGE_BLOOD = 2;

    public static void main(String[] args) {
        int i = (APPLE_FUJI - ORANGE_TEMPLE) / APPLE_PIPPIN;

        System.out.println(Apple.FUJI);
        System.out.println(Apple.FUJI.getValue());

        // type 안정성
        Sample sample = new Sample();
        sample.enumTest(Apple.PIPPIN);
    }

    /**
     * 타입 안정성
     */
    private void enumTest(Apple apple) {
        System.out.println(apple);
    }
}

enum Apple {
    FUJI(1), PIPPIN(2), GRANNY_SMITH(3);

    private final int value;

    Apple(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return super.toString() + ":" + String.valueOf(value);
    }
}


enum Orange {NAVEL, TEMPLE, BLOOD}
