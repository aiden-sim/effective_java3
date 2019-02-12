package chapter5.supertypetoken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class TypeSafetyMap {
	Map<TypeReference<?>, Object> map;

	{
		this.map = new HashMap<>();
	}

	public <T> void put(TypeReference<T> typeReference, T t) {
		map.put(typeReference, t);
	}

	public <T> T get(TypeReference<T> typeReference) {
		Type type = ((ParameterizedType) typeReference.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];

		if (type instanceof Class<?>) {
			return ((Class<T>) type).cast(map.get(typeReference));
		}

		return ((Class<T>) ((ParameterizedType) type).getRawType())
				.cast(map.get(typeReference));
	}

	public static void main(String[] args) {
		TypeSafetyMap map = new TypeSafetyMap();
		map.put(new TypeReference<Integer>() {}, 1);

		// hashCode, equals가 달라져서 결과값이 나오지 않는다.
		System.out.println(map.get(new TypeReference<Integer>() {}));

		// 동일 객체로 처리해서 결과값이 나온다.
		TypeReference tr = new TypeReference<Integer>() {};
		map.put(tr, 1);
		System.out.println(map.get(tr));
	}
}
