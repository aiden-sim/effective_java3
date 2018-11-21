package chapter2.item1;

/**
 * 동반 클래스
 */
public class Sample2 {
	public static void main(String[] args) {
		ParentOldClass empty = CompanionClass.emptyList();
		empty.print();
	}
}

interface ParentOldClass {
	void print();
}

class Boy implements ParentOldClass {
	@Override public void print() {
		System.out.println("나 남자임");
	}
}

class CompanionClass {
	public static final Boy emptyList() {
		return new Boy();
	}
}



