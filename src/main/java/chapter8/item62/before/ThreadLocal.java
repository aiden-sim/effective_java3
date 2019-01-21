package chapter8.item62;

/**
 * 잘못된 예 - 문자열을 사용해 권한을 구분하였다.
 */
public class ThreadLocal {
	private ThreadLocal() {
	} // 객체 생성 불가

	// 현 스레드 값을 키로 구분해 저장
	public static void set(String key, Object value) {

	}

	// (키가 가리키는) 현 스레드의 값을 반환
	public static Object get(String key) {
		return null;
	}
}
