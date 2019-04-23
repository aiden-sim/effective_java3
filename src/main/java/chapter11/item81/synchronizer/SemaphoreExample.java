package chapter11.item81.synchronizer;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
	public static void main(String args[]) {
		Semaphore semaphore = new Semaphore(2);
		Worker mt1 = new Worker(semaphore);
		Worker mt2 = new Worker(semaphore);
		Worker mt3 = new Worker(semaphore);
		Worker mt4 = new Worker(semaphore);
		mt1.start();
		mt2.start();
		mt3.start();
		mt4.start();
	}

	private static class Worker extends Thread {
		private Semaphore semaphore;

		Worker(Semaphore semaphore) {
			this.semaphore = semaphore;
		}

		public void run() {
			try {
				semaphore.acquire();
				System.out.println("Hello " + this.getName());
				try {
					sleep(2000);
				} catch (Exception e) {
				}
			} catch (InterruptedException ie) {
			} finally {
				semaphore.release();
				System.out.println("Goodbye " + this.getName());
			}
		}
	}
}
