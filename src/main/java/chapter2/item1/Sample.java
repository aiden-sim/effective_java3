package chapter2.item1;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.stream.Stream;

public class Sample {
	public static void main(String[] args) {
		autoBoxing();

		constant();

		// 동반 클래스
		try {
			companionClass();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		// 3) 하위 타입 반환 능력
		childClassReturn();

		// 4) 매개변수에 따른 다른 클래스의 객체 반환
		anotherClassReturn();

		// 5) 정적 팩터리 메서드를 작성 시점에 클래스 존재 유무
		driverManager();
		driverManager2();
	}

	private static void autoBoxing() {
		// -127 ~ 128 까지 autoboxing(unboxing) 해서 캐싱 (기본값 변경 가능)
		// -XX:AutoBoxCacheMax= or -Djava.lang.Integer.IntegerCache.high=2000
		Integer a = Integer.valueOf(10);
		Integer b = Integer.valueOf(10);
		int c = 10;

		if (a == b) {
			System.out.println("a와 b가 같음");
		}

		if (b == c) {
			System.out.println("b와 c가 같음");
		}

		if (c == a) {
			System.out.println("a와 c가 같음");
		}

		// No 캐싱
		Integer d = Integer.valueOf(200);
		Integer e = Integer.valueOf(200);
		int f = 200;

		if (d == e) {
			System.out.println("d와 e가 같음");
		}

		if (e == f) {
			System.out.println("e와 f가 같음");
		}

		// 비교 대상중 primitive type의 변수가 하나라도 있으면 값으로 비교
		if (f == d) {
			System.out.println("d와 f가 같음");
		}
	}

	private static void constant() {
		// Interface, final static, Enum
		int number = FinalStaticSample.APPLE;
		int number2 = EnumSample.APPLE.getValue();
		int number3 = InterfaceSample.APPLE;
	}

	// 동반 클래스
	private static void companionClass() throws URISyntaxException {
		// Java8 이전
		Collection<String> empty = Collections.emptyList();

		//Path path = Paths.get(new URI("http://test.com"));

		// Java8 이후
		Stream<String> empty2 = Stream.empty();

	}

	private static void childClassReturnOldType() {
		ParentClass boy = ParentClass.create("남자");
		boy.print();

		ParentClass girl = ParentClass.create("여자");
		girl.print();
	}

	private static void childClassReturn() {
		ParentClass boy = ParentClass.create("남자");
		boy.print();

		ParentClass girl = ParentClass.create("여자");
		girl.print();
	}

	public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

	private static void anotherClassReturn() {
		final EnumSet<Style> styles = EnumSet.noneOf(Style.class);
		styles.addAll(EnumSet.range(Style.BOLD, Style.STRIKETHROUGH));
		styles.removeAll(EnumSet.of(Style.UNDERLINE, Style.STRIKETHROUGH));

		EnumSet.of(Style.BOLD, Style.ITALIC).equals(styles);
		System.out.println(styles);
	}

	/**
	 * 서비스 제공자 프레임워크 (기능과 구현을 분리)
	 */
	private static void driverManager() {
		try {
			// 1) 서비스 인터페이스 : JDBC 인터페이스 스펙 정의 => 벤더사에서 구현 // 여기서는 Connection

			// 2) 제공자 등록 API : DriverManager.registerDriver 를 통해 등록 ==> Class.forName 내부에서 호출

			// + 4) 서비스 제공자 인터페이스 : 생성하는 팩터리 객체를 설명해 준다.
			String driverName = "com.mysql.jdbc.Driver";

			// 정적 팩터리 메서드
			Class.forName(driverName);

			// 3) 서비스 접근 API
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/board", "root", "1234");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void driverManager2() {
		try {
			Class.forName("chapter2.item1.MyDriver");

			// 3) 서비스 접근 API
			Connection conn = DriverManager.getConnection("MyDriver");
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {
		}
	}
}