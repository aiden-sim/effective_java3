package chapter11.item80;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * 출처 : https://github.com/heowc/JavaBasePractice/tree/master/ThreadPool/src/main/java/com/tistory/heowc/threadpool
 */
public class FixedThreadApplication {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		IntStream.range(0, 100)
				.mapToObj(value -> executorService.submit(() -> {
					try {
						if (value % 2 == 0) {
							Thread.sleep(1000L);
						}

						return String.valueOf(value * 2);
					} catch (InterruptedException e) {
						return "";
					}
				}))
				.forEach(action -> {
					try {
						System.out.println("Thread Info  : " + executorService.toString());
						System.out.println("Result Value : " + action.get());
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
					}
				});

		executorService.shutdown();
	}
}