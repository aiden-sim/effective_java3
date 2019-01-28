package chapter10.item78.after;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Atomic 방식
 */
public class StopThread3 {
	private static final AtomicLong nextSerialNum = new AtomicLong();

	public static long generateSerialNumber() {
		return nextSerialNum.getAndIncrement();
	}
}
