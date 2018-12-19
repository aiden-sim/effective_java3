package chapter4.item20;

/**
 * Interface를 이용한 template method 패턴
 */
public interface TemplateMethod {
	void begin();

	void after();

	default void play() {
		begin();
		after();
	}
}
