package chapter5.item29.boundedtypeparameter;

/**
 * boundedTypeParamter Class
 * TypeA는 TypeB와 실제 연관 관계는 없지만 TypeB의 기능을 사용할 수 있다.
 */
public class TypeA<E extends TypeB> {
	public void print(E e) {
		e.print();
	}

	public static void main(String[] args) {
		TypeA<TypeB> type = new TypeA<>();
		type.print(new TypeB());
		type.print(new TypeC());
	}
}

class TypeB {
	public void print() {
		System.out.println("TypeB");
	}
}

class TypeC extends TypeB {
	public void print() {
		System.out.println("TypeC");
	}
}