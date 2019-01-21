package chapter8.item62.after;

/**
 * Key 클래스로 권한 부여
 */
public class ThreadLocal {
	private ThreadLocal() {
	}

	public static class Key { // 권한
		Key() {

		}
	}

	// 위조 불가능한 고유 키를 생성
	public static Key getKey() {
		return new Key();
	}

	public static void set(Key key, Object value) {

	}

	public static Object get(Key key) {
		return null;
	}
}
