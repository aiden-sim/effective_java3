package chapter10.item78.after;

import java.util.concurrent.TimeUnit;

/**
 * volatile 필드를 사용
 */
public class StopThread2 {
	private static volatile boolean stopRequested;

	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(() -> {
			int i = 0;
			while (!stopRequested) {
				i++;
			}
		});
		backgroundThread.start();

		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
	}

	// 동기화가 필요하다.
	private static volatile int nextSerialNumber = 0;

	public static int generateSerialNumber() {
		return nextSerialNumber++;
	}
}
