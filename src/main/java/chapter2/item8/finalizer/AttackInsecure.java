package chapter2.item8.finalizer;

public class AttackInsecure extends Insecure {
    static Insecure insecure;

    public AttackInsecure(int value) {
        super(value);
    }

    public void finalize() {
        insecure = this;
    }

    public static void main(String[] args) {
        try {
            new AttackInsecure(-1);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.gc();
        System.runFinalization();
        if (insecure != null) {
            System.out.println("Insecure object " + insecure + " created!");
        }
    }
}
