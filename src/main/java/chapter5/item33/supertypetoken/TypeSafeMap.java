package chapter5.item33.supertypetoken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class TypeSafeMap {

	//  private Map<Class<?>, Object> map = new HashMap<>();
	private Map<Type, Object> map = new HashMap<>();  // key로 사용되던 Class<?> 대신 Type으로 변경

	//  public <T> void put(Class<T> k, T v) {
	//      map.put(k, v);
	//  }
	public <T> void put(TypeReference<T> k, T v) {  // 수퍼 타입을 추출할 수 있는 TypeReference<T>를 인자로 받음
		map.put(k.getType(), v);  // key가 Type으로 바뀌었으므로 기존의 k 대신 k.getType()으로 변경
	}

	//  public <T> T get(Class<T> k) {
	//      return k.cast(map.get(k));
	//  }
	public <T> T get(TypeReference<T> k) {  // key로 TypeReference<T>를 사용하도록 수정
		if (k.getType() instanceof ParameterizedType)
			return ((Class<T>) ((ParameterizedType) k.getType()).getRawType()).cast(map.get(k.getType()));
		else
			return ((Class<T>) k.getType()).cast(map.get(k.getType()));
	}
}