package chapter11.item80;

/**
 * 출처 : https://github.com/heowc/JavaBasePractice/tree/master/ThreadPool/src/main/java/com/tistory/heowc/threadpool
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SingleThreadApplication {

	public static void main(String [] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		IntStream.range(0, 10)
				.forEach(action -> executorService.execute(() -> System.out.println(executorService.toString())));
		executorService.shutdown();
	}
}
