package chapter2.item8.finalizer;

import java.io.FilePermission;

public class Insecure {
    Integer value = 0;

    public Insecure(int value) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            FilePermission fp = new FilePermission("index", "write");
            sm.checkPermission(fp);
        }
        this.value = value;
    }

    @Override
    public String toString() {
        return (value.toString());
    }
}
