package chapter5.item30;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 제네릭 싱글턴 패턴
 * 매개변수에 맞게 매번 그 객체의 타입을 바꿔주는 정적 팩터리
 */
public class Sample4 {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(30);
		al.add(20);
		al.add(10);
		al.add(40);
		al.add(50);

        /* Collections.sort method is sorting the
        elements of ArrayList in descending order. */
		Collections.sort(al, Collections.reverseOrder()); // reverseOrder는 제네릭 싱글턴 패턴

		// Let us print the sorted list
		System.out.println("List after the use of Collection.reverseOrder()" +
				" and Collections.sort() :\n" + al);
	}
}
