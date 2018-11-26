package chapter2.item7;

import java.util.ArrayList;
import java.util.Random;

public class Container<T> {

	// 런타임에서 Object가 된다.
	private T data;

	public T getData() {
		return data;
	}

	private static Random random = new Random();
	public static final ArrayList<Double> list = new ArrayList<Double>(1000000);

	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < 10000000; i++) {
			list.add(random.nextDouble());
		}

		//addElementsToTheList();
		System.out.println("test");

		System.gc();
		Thread.sleep(10000); // to allow GC do its job
	}

	private static void addElementsToTheList() {
		ArrayList<Double> list = new ArrayList<Double>(10000000);
		for (int i = 0; i < 10000000; i++) {
			list.add(random.nextDouble());
		}
	}

}