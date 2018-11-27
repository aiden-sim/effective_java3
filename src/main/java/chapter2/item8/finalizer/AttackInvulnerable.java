package chapter2.item8.finalizer;

public class AttackInvulnerable extends Invulnerable {
    static Invulnerable vulnerable;

    public AttackInvulnerable(int value) {
        super(value);
    }

    public void finalize() {
        vulnerable = this;
    }

    public static void main(String[] args) {
        try {
            new AttackInvulnerable(-1);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.gc();
        System.runFinalization();
        if (vulnerable != null) {
            System.out.println("Invulnerable object " + vulnerable + "created !");
        } else {
            System.out.println("Attack failed");
        }
    }
}