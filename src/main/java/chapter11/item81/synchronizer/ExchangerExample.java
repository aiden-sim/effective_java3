package chapter11.item81.synchronizer;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
	public static void main(String[] args) {
		Exchanger exchanger = new Exchanger();

		Worker worker1 = new Worker(exchanger, "AAA");
		Worker worker2 = new Worker(exchanger, "BBB");
		new Thread(worker1).start();
		new Thread(worker2).start();
	}

	private static class Worker extends Thread {
		Exchanger<String> exchanger;
		String message;

		Worker(Exchanger<String> exchanger, String message) {
			this.exchanger = exchanger;
			this.message = message;
		}

		public void run() {
			try {
				System.out.println(this.getName() + " message: " + message);

				// exchange messages
				message = exchanger.exchange(message);

				System.out.println(this.getName() + " message: " + message);
			} catch (Exception e) {
			}
		}
	}
}
