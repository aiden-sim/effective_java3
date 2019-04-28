package chapter11.item78.after;

import net.jcip.annotations.Immutable;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * volatile 필드를 사용
 */
public class StopThread2 {
    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            long startTime = System.currentTimeMillis();
            while (!stopRequested) {
                i++;
            }
            long endTime = System.currentTimeMillis();
            long measuredTime = endTime - startTime;
            System.out.println(measuredTime);
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }

    // 밑에는 잘못된 코드
    // 동기화가 필요하다.
    private static volatile int nextSerialNumber = 0;

    public static int generateSerialNumber() {
        return nextSerialNumber++;
    }
}