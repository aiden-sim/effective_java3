package chapter12.item87;

import java.io.Serializable;

// 기본 직렬화에 적합한 후보
public class Name implements Serializable {
    /**
     * 성. null이 아니어야 함.
     *
     * @serial
     */
    private final String lastName;

    /**
     * 이름. null이 아니어야 함
     *
     * @serial
     */
    private final String firstName;

    /**
     * 중간이름. 중간이름이 없다면 null.
     *
     * @serial
     */
    private final String middleName;

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
}
