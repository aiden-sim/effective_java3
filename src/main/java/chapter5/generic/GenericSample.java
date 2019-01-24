package chapter5.generic;

public class GenericSample {
	public static void main(String[] ar) {
		GenericSample ex = new GenericSample();
		ex.checkCastingDTO();
	}

	public void checkCastingDTO() {
		CastingDTO dto1 = new CastingDTO();
		dto1.setObject(new String());

		CastingDTO dto2 = new CastingDTO();
		dto2.setObject(new StringBuffer());

		CastingDTO dto3 = new CastingDTO();
		dto3.setObject(new StringBuilder());

		// 캐스팅을 적어주어야 한다.
		// 많아 지면???? Hell
		// 또한 타입변환을 잘못 했다면???? Hell
		String temp1 = (String) dto1.getObject();
		StringBuffer temp2 = (StringBuffer) dto2.getObject();
		StringBuilder temp3 = (StringBuilder) dto3.getObject();
	}

	public void checkDTO(CastingDTO dto) {
		Object tempObject = dto.getObject();
		if (tempObject instanceof String) {
			System.out.println("String dto");
		} else if (tempObject instanceof StringBuffer) {
			System.out.println("StringBuffer dto");
		} else if (tempObject instanceof StringBuilder) {
			System.out.println("StringBuilder dto");
		}
	}
}