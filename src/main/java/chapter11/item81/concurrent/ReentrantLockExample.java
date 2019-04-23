package chapter11.item81.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
	private static ReentrantLock lock = new ReentrantLock();

	public static void main(String[] args) {
		lock.lock();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		} finally {
			lock.unlock();
		}
	}
}
