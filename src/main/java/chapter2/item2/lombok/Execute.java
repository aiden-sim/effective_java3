package chapter2.item2.lombok;

public class Execute {
	public static void main(String[] args) {
		UserProfile userProfile = UserProfile.builder()
				.userName("심준보")
				.userSeq(1)
				.email("simjunbo@tmon.co.kr")
				.build();

	}
}
