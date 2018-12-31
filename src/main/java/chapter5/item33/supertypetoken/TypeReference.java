package chapter5.item33.supertypetoken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class TypeReference<T> {

	private Type type;

	protected TypeReference() {
		Type superClassType = getClass().getGenericSuperclass();
		if (!(superClassType instanceof ParameterizedType)) {  // sanity check
			throw new IllegalArgumentException("TypeReference는 항상 실제 타입 파라미터 정보와 함께 생성되어야 합니다.");
		}
		this.type = ((ParameterizedType) superClassType).getActualTypeArguments()[0];
	}

	public Type getType() {
		return type;
	}
}