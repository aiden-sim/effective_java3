package chapter9.item63;

public class Sample {
	/**
	 * 문자열 연결을 잘못사용한 예 (느림)
	 */
	public String statement() {
		String result = "";
		for (int i = 0; i < numItems(); i++) {
			result += lineForItem(i);
		}
		return result;
	}

	private String lineForItem(int i) {
		return "test";
	}

	private int numItems() {
		return 10;
	}

	final int LINE_WIDTH = 100;

	// StringBuilder를 사용하면 문자열 연결 성능이 크게 개선
	public String statement2() {
		StringBuilder b = new StringBuilder(numItems() * LINE_WIDTH);
		for (int i = 0; i < numItems(); i++) {
			b.append(lineForItem(i));
		}
		return b.toString();
	}
}
