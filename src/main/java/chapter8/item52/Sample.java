package chapter8.item52;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static chapter8.item52.Print.println;

public class Sample {
	public static void main(String[] args) {
		// 1번 Thread의 생성자 호출
		new Thread(System.out::println).start();

		// 2번 ExecutorService의 submit 메서드 호출
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.submit(Print::println); // Print가 다중정의 되어 있기 때문에 에러난다.
		System.out.println();
	}
}

class Print {

	// runnable
	public static void println() {
	}

	// callable
	/*public static String println() {
		return "test";
	}*/
}