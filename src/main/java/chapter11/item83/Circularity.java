package chapter11.item83;

public class Circularity {

}

class A {
	static int x = 1;

	static {
		B.y = 1;
	}
}

class B {
	static int y = 2;

	static {
		A.x = 2;
	}
} 
