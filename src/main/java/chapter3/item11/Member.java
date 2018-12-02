package chapter3.item11;

import java.util.Objects;

public class Member {
    private String name;
    private int age;
    private String nickname;

    public Member(String name, int age, String nickname) {
        this.name = name;
        this.age = age;
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Member)) {
            return false;
        }

        Member member = (Member) obj;
        return member.name.equals(name) && member.age == age;
    }

    /*
    @Override
    public int hashCode() {
        int result = ((name == null) ? 0 : name.hashCode()); // 참조 타입 필드라면
        result = 31 * result + Integer.hashCode(age);        // 기본 타입 필드라면 Type.hashCode(f)
        return result;
    }
    */

    // 성능적으로는 더 느리나 간편하다. (배열이 만들어 지고 박싱, 언박싱도 거쳐야 되기 때문)
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static void main(String[] args) {
        Member member = new Member("심준보", 33, "심준보");
        Member memebr2 = new Member("심준보", 33, "심준보");

        if (member.equals(memebr2)) {
            System.out.println("같은 값");
        }

        if (member.hashCode() == memebr2.hashCode()) {
            System.out.println("같은 hashcode");
        }
    }
}
