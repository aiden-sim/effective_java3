package chapter2.item8.finalizer;

public class AttackVulnerable extends Vulnerable {
    static Vulnerable vulnerable;

    public AttackVulnerable(int value) {
        super(value);
    }

    public void finalize() {
        vulnerable = this;
    }

    public static void main(String[] args) {
        try {
            new AttackVulnerable(-1);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.gc();
        System.runFinalization();
        if (vulnerable != null) {
            System.out.println("Vulnerable object " + vulnerable + " created!");
        }
    }
}