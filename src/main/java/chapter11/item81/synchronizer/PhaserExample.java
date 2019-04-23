package chapter11.item81.synchronizer;

import java.util.concurrent.Phaser;

public class PhaserExample {
	public static void main(String[] args) {
		Phaser phaser = new Phaser();

		Thread t1 = new Worker(phaser, 1000);
		Thread t2 = new Worker(phaser, 3000);
		Thread t3 = new Worker(phaser, 10000);
		t1.start();
		t2.start();
		t3.start();
	}

	private static class Worker extends Thread {
		Phaser phaser;
		int sleep;

		Worker(Phaser phaser, int sleep) {
			this.phaser = phaser;
			this.sleep = sleep;
		}

		public void run() {
			phaser.register();
			System.out.println(this.getName() + " begin");
			try {
				Thread.sleep(sleep);
			} catch (Exception e) {
			}
			phaser.arriveAndAwaitAdvance();
			System.out.println(this.getName() + " middle");
			try {
				Thread.sleep(sleep);
			} catch (Exception e) {
			}
			System.out.println(this.getName() + " end");
		}
	}
}
