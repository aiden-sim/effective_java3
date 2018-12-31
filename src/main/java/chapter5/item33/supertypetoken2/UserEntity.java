package chapter5.item33.supertypetoken2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 참고 : http://blog.woniper.net/319
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
	private String username;
	private int age;

	// getter and setter
}
