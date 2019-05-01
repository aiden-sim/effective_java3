package chapter11.item82.doc;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, FooDoer> globalMap = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            // thread 1 - attacker
            FooDoer f = new FooDoer();
            globalMap.put("TheFoo", f);
            synchronized (f) {
                while (true) ; // haha!
            }
        };
        new Thread(task).start();

        Thread.sleep(1000);

        Runnable task2 = () -> {
            // thread 2 - victim
            FooDoer f = globalMap.get("TheFoo");
            f.foo(); // locked, because Thread 1 has locked us out!
        };
        new Thread(task2).start();
    }
}

class FooDoer {
    /*
    synchronized void foo() {
        System.out.println("test");
    }*/

    // removed! using synchronized methods instead

    private final Object lock = new Object();

    void foo() {
        synchronized (lock) {
            System.out.println("test");
        }
    }
}