package chapter2.item1;

import chapter2.item1.externalapi.Boy;
import chapter2.item1.externalapi.Girl;

public interface ParentClass {
	void print();

	static ParentClass create(String gender) {
		if ("남자".equals(gender)) {
			return new Boy();
		} else {
			return new Girl();
		}
	}
}



