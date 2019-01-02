package chapter6.item35;

/**
 * ordinal을 잘못 사용한 예
 */
public enum Ensemble {
	SOLO, DUET, TRIO, QUARTET, QUINTET, SEXTET, SEPTET, OCTET, NONET, DECTET;

	public int numberOfMusicians() {
		return ordinal() + 1;
	}

	public static void main(String[] args) {
		System.out.println(Ensemble.SOLO.numberOfMusicians());
	}
}
