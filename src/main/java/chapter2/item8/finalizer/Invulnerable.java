package chapter2.item8.finalizer;

public class Invulnerable {
    Integer value = 0;

    Invulnerable(int value) {
        this(checkValues(value));
        this.value = value;
    }

    private Invulnerable(Void checkValues) {
    }

    static Void checkValues(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Invulnerable value must be positive");
        }
        return null;
    }

    @Override
    public String toString() {
        return (Integer.toString(value));
    }
}