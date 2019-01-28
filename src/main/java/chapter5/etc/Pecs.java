package chapter5.etc;

import java.util.ArrayList;
import java.util.List;

class A {
}

class B extends A {
}

class C extends B {
}

public class Pecs {
	public static void main(String[] args) {

	}

	private void child() {
		// C assign C
		// C get A, B, C
		List<? extends C> c = new ArrayList<C>();

		// B assign B, C
		// B get A, B
		List<? extends B> b1 = new ArrayList<B>();
		List<? extends B> b2 = new ArrayList<C>();

		// A assign A, B, C
		// A get A
		List<? extends A> a1 = new ArrayList<A>();
		List<? extends A> a2 = new ArrayList<B>();
		List<? extends A> a3 = new ArrayList<C>();
	}

	private void parent() {
		// C assign Object, A, B, C
		// add C
		List<? super C> c1 = new ArrayList<C>();
		List<? super C> c2 = new ArrayList<B>();
		List<? super C> c3 = new ArrayList<A>();
		List<? super C> c4 = new ArrayList<Object>();
		c1.add(new C() {
		});

		// B assign Object, A, B
		// add B, C
		List<? super B> b1 = new ArrayList<B>();
		List<? super B> b2 = new ArrayList<A>();
		List<? super B> b3 = new ArrayList<Object>();
		b1.add(new B());
		b1.add(new C());

		b2.add(new B());
		b2.add(new C());

		// C assign Object, A
		// add A, B, C
		List<? super A> a1 = new ArrayList<A>();
		List<? super A> a2 = new ArrayList<Object>();
		a1.add(new A());
		a1.add(new B());
		a1.add(new C());

		a2.add(new A());
		a2.add(new B());
		a2.add(new C());


	}
}
