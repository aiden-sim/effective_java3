package chapter5.item33.supertypetoken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 참고 : https://homoefficio.github.io/2016/11/30/%ED%81%B4%EB%9E%98%EC%8A%A4-%EB%A6%AC%ED%84%B0%EB%9F%B4-%ED%83%80%EC%9E%85-%ED%86%A0%ED%81%B0-%EC%88%98%ED%8D%BC-%ED%83%80%EC%9E%85-%ED%86%A0%ED%81%B0/
 */
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