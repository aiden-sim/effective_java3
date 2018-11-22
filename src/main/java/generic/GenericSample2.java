package generic;

public class GenericSample2 {
	public static void main(String[] ar) {
		GenericSample2 ex = new GenericSample2();
		ex.checkGenericDTO();
	}

	public void checkGenericDTO() {
		CastingGenericDTO<String> dto1 = new CastingGenericDTO<>();
		dto1.setObject(new String());
		CastingGenericDTO<StringBuffer> dto2 = new CastingGenericDTO<>();
		dto2.setObject(new StringBuffer());
		CastingGenericDTO<StringBuilder> dto3 = new CastingGenericDTO<>();
		dto3.setObject(new StringBuilder());

		// 컴파일 단에서 에러가 난다.
		String temp1 = dto1.getObject();
		StringBuffer temp2 = dto2.getObject();
		StringBuilder temp3 = dto3.getObject();
	}
}