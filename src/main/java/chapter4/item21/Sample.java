package chapter4.item21;

import java.util.ArrayList;

public class Sample {
	public static void main(String[] args) {

		// create an ArrayList which going to
		// contains a list of Numbers
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		// Add Number to list
		numbers.add(23);
		numbers.add(32);
		numbers.add(45);
		numbers.add(63);

		// apply removeIf() method
		// we are going toremove numbers divisible by 3
		numbers.removeIf(n -> (n % 3 == 0));

		// print list
		for (int i : numbers) {
			System.out.println(i);
		}
	}
}
