package chapter2.item8.finalizer;

public class Zombie {
    static Zombie zombie;

    public void finalize() {
        zombie = this;
    }
}