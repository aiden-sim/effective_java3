package chapter5.etc;

/**
 * Case1 타임 파라미터 연관 없는 설계
 */

/**
 * 연관이 없는 설계
 */
interface Box<T> {
	void print(T t);

	<U> void printBox(U info);
}

/**
 * 연관 있게 설계
 */
interface Box2<T, U, R> {
	R apply(T t, U u);
}