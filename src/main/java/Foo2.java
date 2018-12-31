public enum Foo2 {
    FUJI(100), PIPPIN(2), GRANNY_SMITH(3);

    private final int value;

    Foo2(int value) {
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