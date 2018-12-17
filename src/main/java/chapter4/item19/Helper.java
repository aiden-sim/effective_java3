package chapter4.item19;

public class Helper {

	// 재정의 가능한 메서드
	public void print(String str) {
		printHelperMethod(str);
	}

	// private 도우미 메서드
	private void printHelperMethod(String str) {
		System.out.println(str);
	}

	// 자기 사용 포함 ( 도우미 메서드 호출 ) : 재정의 기능 제거
	protected void name() {
		String name = "simjunbo";
		printHelperMethod(name);
	}

	// 자기 사용 포함 ( 재정의 가능한 메서드 호출 )
	protected void age() {
		String age = "33";
		print(age);
	}

}

class Child extends Helper {

	@Override
	public void print(String str) {
		System.out.println("상속");
	}

	public static void main(String[] args) {
		Child child = new Child();
		child.name(); // 도우미 메서드 사용하면 하위 클래스 영향 없다.
		child.age(); // 재정의 가능 메서드 사용하면 하위 클래스 오버라이드가 호출된다.
	}
}