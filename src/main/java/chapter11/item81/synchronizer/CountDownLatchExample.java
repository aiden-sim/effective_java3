package chapter11.item81.synchronizer;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
	private static final int MAX = 10;

	public static void countdownlatch() throws Exception {
		CountDownLatch latch = new CountDownLatch(MAX);
		long start = System.currentTimeMillis();
		for (long i = 0; i < MAX; i++) {
			new Thread(new Worker(latch)).start();
		}

		latch.await(); // MAX count가 다 끝날때까지 기다린다.
		//latch.await(2000, TimeUnit.MILLISECONDS); // MAX count가 끝나지 않아도 timeout 이후에 종료
		long elapsedTime = System.currentTimeMillis() - start;
		System.out.println("elapsedTime -> " + elapsedTime);
	}

	private static class Worker implements Runnable {
		private CountDownLatch latch;

		public Worker(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} finally {
				if (this.latch == null)
					return;

				latch.countDown();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		countdownlatch();
	}
}
