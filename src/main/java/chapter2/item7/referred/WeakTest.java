package chapter2.item7.referred;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by simjunbo on 2018-11-27.
 */
public class WeakTest {
    private static Map<String, String> map;

    public static void main(String args[]) {
        map = new WeakHashMap<>();
        map.put(new String("Scott"), "McNealey");
        Runnable runner = new Runnable() {
            public void run() {
                while (map.containsKey("Scott")) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ignored) {
                    }
                    System.out.println("Checking for empty");
                    System.gc();
                }
            }
        };

        Thread t = new Thread(runner);
        t.start();
        System.out.println("Main joining");
        try {
            t.join();
        } catch (InterruptedException ignored) {
        }
    }
}