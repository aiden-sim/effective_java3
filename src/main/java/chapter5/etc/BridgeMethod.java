package chapter5.etc;

import java.lang.reflect.Method;

public class BridgeMethod {
	public static class A<T> {
		public T getT(T args) {
			return args;
		}
	}

	public static class B extends A<String> {
		public String getT(String args) {
			return args;
		}
	}
}

class BridgeMethodTest {
	public static void main(String[] args) {
		test(BridgeMethod.B.class);
	}

	public static boolean test(Class c) {
		Method[] methods = c.getMethods();

		for (Method method : methods) {
			if (method.isSynthetic() || method.isBridge()) {
				System.out.println("Method Name =" + method.getName());
				System.out.println("Method isBridge =" + method.isBridge());
				System.out.println("Method isSynthetic =" + method.isSynthetic());
				return true;
			}
		}
		return false;
	}
}
