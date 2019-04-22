package chapter11.item80;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * 출처 : https://github.com/heowc/JavaBasePractice/tree/master/ThreadPool/src/main/java/com/tistory/heowc/threadpool
 */
public class CachedThreadApplication {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("================ getFairIsTrueCachedExecutorService");
		ExecutorService executorService1 = getFairIsTrueCachedExecutorService();
		printExecutorService(executorService1);
		executorService1.shutdown();

		Thread.sleep(3000L);

		System.out.println("================ getFairIsFalseCachedExecutorService");
		ExecutorService executorService2 = getFairIsFalseCachedExecutorService();
		printExecutorService(executorService2);
		executorService2.shutdown();
	}

	private static ExecutorService getFairIsTrueCachedExecutorService() {
		return Executors.newCachedThreadPool();

	}

	/**
	 * newCachedThreadPool 내부 적으로 동작
	 */
	private static ExecutorService getFairIsFalseCachedExecutorService() {
		return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
				60L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>(true));
	}

	private static void printExecutorService(ExecutorService executorService) {
		IntStream.range(0, 10)
				.mapToObj(value -> executorService.submit(() -> value))
				.forEach(action -> {
					executorService.submit(() -> {
						try {
							System.out.println(executorService.toString());
							System.out.println(action.get());
						} catch (InterruptedException | ExecutionException e) {
							e.printStackTrace();
						}
					});
				});
	}
}
