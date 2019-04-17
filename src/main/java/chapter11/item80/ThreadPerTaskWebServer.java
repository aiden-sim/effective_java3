package chapter11.item80;

/**
 * 요청이 들어 올때마다 새로운 스레드를 생성
 */
public class ThreadPerTaskWebServer {
	public static void main(String[] args) {
		while (true) {
			Runnable task = () -> {
				System.out.println("test");
			};
			new Thread(task).start();
		}
	}
}
