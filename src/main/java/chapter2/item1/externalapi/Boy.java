package chapter2.item1.externalapi;

import chapter2.item1.ParentClass;

public class Boy implements ParentClass {

	@Override public void print() {
		System.out.println("나 남자임");
	}
}