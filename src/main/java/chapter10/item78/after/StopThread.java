package chapter10.item78.after;

import java.util.concurrent.TimeUnit;

/**
 * 적절히 동기화해 스레드가 정상 종료한다.
 */
public class StopThread {
	private static boolean stopRequested;

	private static synchronized void requestStop() {
		stopRequested = true;
	}

	private static synchronized boolean stopRequested() {
		return stopRequested;
	}

	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(() -> {
			int i = 0;
			while (!stopRequested()) {
				i++;
			}
		});
		backgroundThread.start();

		TimeUnit.SECONDS.sleep(1);
		requestStop();
	}
}
