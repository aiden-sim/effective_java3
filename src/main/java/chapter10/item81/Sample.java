package chapter10.item81;

import java.util.Random;
import java.util.concurrent.*;

public class Sample {
	private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

	// concurrentMap으로 구현한 동시성 정규화 맵 (최적 아님)
	public static String intern(String s) {
		String previousValue = map.putIfAbsent(s, s);
		return previousValue == null ? s : previousValue;
	}

	// concurrentMap으로 구현한 동시성 정규화 맵 (더 빠름)
	public static String intern2(String s) {
		String result = map.get(s);
		if (result == null) {
			result = map.putIfAbsent(s, s);
			if (result == null) {
				result = s;
			}
		}
		return result;
	}

	// 동시 실행 시간을 재는 간단한 프레임워크
	public static long time(Executor executor, int concurrency, Runnable action) throws InterruptedException {
		CountDownLatch ready = new CountDownLatch(concurrency);
		CountDownLatch start = new CountDownLatch(1);
		CountDownLatch done = new CountDownLatch(concurrency);

		for (int i = 0; i < concurrency; i++) {
			executor.execute(() -> {
				ready.countDown();
				try {
					// 모든 작업아 스레드가 준비될 때까지 기다린다
					start.await();
					action.run();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				} finally {
					done.countDown();
				}
			});
		}

		ready.await(); // 모든 작업자가 준비될 때까지 기다린다.
		long startNanos = System.nanoTime();
		start.countDown(); // 작업자들을 깨운다.
		done.await();      // 모든 작업자가 일을 끝마치기를 기다린다.
		// 모든 작업아 스레드가 준비될 때까지 기다린다
		return System.nanoTime() - startNanos;

	}

	public static void main(String[] args) throws InterruptedException {
		intern2("test");

		ExecutorService service = Executors.newFixedThreadPool(4);
		long result = time(service, 1, new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		System.out.println(result);
	}
}
