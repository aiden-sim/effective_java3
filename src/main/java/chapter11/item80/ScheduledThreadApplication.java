package chapter11.item80;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 출처 : https://github.com/heowc/JavaBasePractice/tree/master/ThreadPool/src/main/java/com/tistory/heowc/threadpool
 */
public class ScheduledThreadApplication {

	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

		IntStream.range(0, 100)
				.forEach(action -> scheduledExecutorService.schedule(() -> {
					System.out.println(scheduledExecutorService.toString());
					System.out.println(action);
				}, 5000L, TimeUnit.MILLISECONDS));
		scheduledExecutorService.shutdown();
	}
}