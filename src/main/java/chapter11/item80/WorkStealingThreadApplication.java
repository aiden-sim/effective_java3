package chapter11.item80;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * 출처 : https://github.com/heowc/JavaBasePractice/tree/master/ThreadPool/src/main/java/com/tistory/heowc/threadpool
 */
public class WorkStealingThreadApplication {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newWorkStealingPool(3);

		IntStream.range(0, 500)
				.forEach(action -> executorService.execute(() -> System.out.println(executorService.toString())));
	}
}