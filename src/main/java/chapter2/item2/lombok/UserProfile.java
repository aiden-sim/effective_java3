package chapter2.item2.lombok;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserProfile {
	private final int userSeq;
	private final String userName;
	private final String email;

	@Builder
	private UserProfile(int userSeq, String userName, String email) {
		this.userSeq = userSeq;
		this.userName = userName;
		this.email = email;
	}
}