package chapter11.item82;

public class PrivateLock {

	private final Object lock = new Object();

	public void fooe() {
		synchronized (lock) {
			
		}
	}
}
