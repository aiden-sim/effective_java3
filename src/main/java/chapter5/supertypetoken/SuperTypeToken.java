package chapter5.supertypetoken;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SuperTypeToken {

	public static void main(String[] args) {
		Sub sub = new Sub();
		System.out.println(((ParameterizedType) sub.getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName());

		// Sub class를 사용 안하고 익명 클래스를 사용할 수 있다.
		// 꼭 {}를 붙여줘야지 하위 타입으로 인식한다.
		TypeReference sub1 = new TypeReference<String>() {
		};
		TypeReference sub2 = new TypeReference<Integer>() {
		};

		System.out.println(((ParameterizedType) sub1.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0]
				.getTypeName());

		System.out.println(((ParameterizedType) sub2.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0]
				.getTypeName());

		// List나 Map 정보도 남을까?
		TypeReference intType = new TypeReference<List<Integer>>(){};
		TypeReference stringType = new TypeReference<Set<Map<String, List<Integer>>>>(){};

		System.out.println(((ParameterizedType)intType.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0]
				.getTypeName());

		System.out.println(((ParameterizedType)stringType.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0]
				.getTypeName());

		 /*
			result :
			java.util.List<java.lang.Integer>
			java.util.Set<java.util.Map<java.lang.String, java.util.List<java.lang.Integer>>>
		 */



	}
}

/**
 * 컴파일 안전성을 위해 추상 클래스로 정의
 */
abstract class TypeReference<T> {
}

class Sub extends TypeReference<String> {
}
