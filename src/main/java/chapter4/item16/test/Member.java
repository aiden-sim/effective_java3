package chapter4.item16.test;

import java.io.*;
import java.util.Base64;

public class Member implements Serializable {
	private String name;
	private String email;
	private int age;

	public Member(String name, String email, int age) {
		this.name = name;
		this.email = email;
		this.age = age;
	}

	// Getter 생략

	@Override
	public String toString() {
		return String.format("Member{name='%s', email='%s', age='%s'}", name, email, age);
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Member member = new Member("김배민", "deliverykim@baemin.com", 25);
		byte[] serializedMember;
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
				oos.writeObject(member);
				// serializedMember -> 직렬화된 member 객체
				serializedMember = baos.toByteArray();
			}
		}
		// 바이트 배열로 생성된 직렬화 데이터를 base64로 변환
		String base64Member = Base64.getEncoder().encodeToString(serializedMember);
		byte[] serializedMember2 = Base64.getDecoder().decode(base64Member);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember2)) {
			try (ObjectInputStream ois = new ObjectInputStream(bais)) {
				// 역직렬화된 Member 객체를 읽어온다.
				Object objectMember = ois.readObject();
				Member member2 = (Member) objectMember;
				System.out.println(member);
			}
		}
	}
}