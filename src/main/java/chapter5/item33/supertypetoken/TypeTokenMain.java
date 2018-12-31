package chapter5.item33.supertypetoken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 참고 : https://homoefficio.github.io/2016/11/30/%ED%81%B4%EB%9E%98%EC%8A%A4-%EB%A6%AC%ED%84%B0%EB%9F%B4-%ED%83%80%EC%9E%85-%ED%86%A0%ED%81%B0-%EC%88%98%ED%8D%BC-%ED%83%80%EC%9E%85-%ED%86%A0%ED%81%B0/
 */
public class TypeTokenMain {
	public static void main(String[] args) {

		class SimpleTypeSafeMap {

			private Map<Class<?>, Object> map = new HashMap<>();

			public <T> void put(Class<T> k, T v) {
				map.put(k, v);
			}

			public <T> T get(Class<T> k) {
				return k.cast(map.get(k));
			}
		}

		SimpleTypeSafeMap simpleTypeSafeMap = new SimpleTypeSafeMap();

		simpleTypeSafeMap.put(String.class, "abcde");
		simpleTypeSafeMap.put(Integer.class, 123);

		// 타입 토큰을 이용해서 별도의 캐스팅 없이도 타입 안전성이 확보된다.
		String v1 = simpleTypeSafeMap.get(String.class);
		Integer v2 = simpleTypeSafeMap.get(Integer.class);

		System.out.println(v1);
		System.out.println(v2);

		// Super Type Token
		// List<String>.class 같은 형식의 타입 토큰을 사용할 수 없다.
		// simpleTypeSafeMap.put(List<String>.class, Arrays.asList("a", "b", "c"));

		class Super<T> {
		}

		// 수퍼 클래스에 사용되는 파라미터 타입을 이용한다. 그래서 수퍼 타입 토큰.
		class Sub extends Super<List<String>> {
		}

		Sub sub = new Sub();

		// 파라미터 타입 정보가 포함된 수퍼 클래스의 타입 정보를 구한다.
		Type typeOfGenericSuperclass = sub.getClass().getGenericSuperclass();

		// ~~~$1Super<java.util.List<java.lang.String>> 라고 나온다!!
		System.out.println(typeOfGenericSuperclass);

		// 수퍼 클래스가 ParameterizedType 이므로 ParameterizedType으로 캐스팅 가능
		// ParameterizedType의 getActualTypeArguments()으로 실제 타입 파라미터의 정보를 구한다!!
		Type actualType = ((ParameterizedType) typeOfGenericSuperclass).getActualTypeArguments()[0];

		// 심봤다! java.util.List<java.lang.String>가 나온다!!
		System.out.println(actualType);

		//simpleTypeSafeMap.put(actualType, Arrays.asList("a", "b", "c")); // 여기서 에러!!
	}
}
