package chapter4.item20;

import java.util.AbstractList;

/**
 * 내부 클래스 방식 (래퍼 클래스랑 비슷)
 */
public class OuterClass {
	private InnerClass innerClass;

	OuterClass(int a[]) {
		innerClass = new InnerClass(a);
	}

	public Integer get(int i) {
		return innerClass.get(i);
	}

	public int size() {
		return innerClass.size();
	}

	private static class InnerClass extends AbstractList {

		int[] a;

		InnerClass(int[] a) {
			this.a = a;
		}

		@Override public Integer get(int i) {
			return a[i];
		}

		@Override public int size() {
			return a.length;
		}
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };
		OuterClass sample = new OuterClass(a);
		System.out.println(sample.get(0));
		System.out.println(sample.size());
	}
}
