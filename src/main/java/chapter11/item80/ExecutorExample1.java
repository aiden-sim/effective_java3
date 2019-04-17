package chapter11.item80;

import java.util.concurrent.*;

/**
 * newFixedThreadPool
 */
public class ExecutorExample1 {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		executor.submit(() -> System.out.println("I'm Runnable task."));

		Future<Integer> futureTask1 = executor.submit(() -> {
			System.out.println("I'm Callable task.");
			return 1 + 1;
		});

		try {

			otherTask("Before Future Result");

			// block until future returned a result,
			// timeout if the future takes more than 5 seconds to return the result
			Integer result = futureTask1.get(5, TimeUnit.SECONDS);

			System.out.println("Get future result : " + result);

			otherTask("After Future Result");


		} catch (InterruptedException e) {// thread was interrupted
			e.printStackTrace();
		} catch (ExecutionException e) {// thread threw an exception
			e.printStackTrace();
		} catch (TimeoutException e) {// timeout before the future task is complete
			e.printStackTrace();
		} finally {

			// shut down the executor manually
			executor.shutdown();
		}

	}

	private static void otherTask(String name) {
		System.out.println("I'm other task! " + name);
	}
}