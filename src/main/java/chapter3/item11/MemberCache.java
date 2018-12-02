package chapter3.item11;

public class MemberCache {

    // 캐시
    private int hashCode;

    private String name;
    private int age;
    private String nickname;

    public MemberCache(String name, int age, String nickname) {
        this.name = name;
        this.age = age;
        this.nickname = nickname;
        //this.hashCode = getHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MemberCache)) {
            return false;
        }

        MemberCache member = (MemberCache) obj;
        return member.name.equals(name) && member.age == age;
    }

    // 캐시 (pre loading)
    /*
    private int getHashCode() {
        int result = ((name == null) ? 0 : name.hashCode()); // 참조 타입 필드라면
        result = 31 * result + Integer.hashCode(age);        // 기본 타입 필드라면 Type.hashCode(f)
        return result;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }
    */

    // 캐시 (lazy loading)
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = ((name == null) ? 0 : name.hashCode()); // 참조 타입 필드라면
            result = 31 * result + Integer.hashCode(age);        // 기본 타입 필드라면 Type.hashCode(f)
            hashCode = result;
        }
        return result;
    }


    public static void main(String[] args) {
        MemberCache member = new MemberCache("심준보", 33, "심준보");
        MemberCache memebr2 = new MemberCache("심준보", 33, "심준보");

        if (member.equals(memebr2)) {
            System.out.println("같은 값");
        }

        if (member.hashCode() == memebr2.hashCode()) {
            System.out.println("같은 hashcode");
        }

        // lazy loading 인 경우 두번째 호출 부터 캐싱된 값을 사용한다.
        if (member.hashCode() == memebr2.hashCode()) {
            System.out.println("같은 hashcode");
        }
    }
}
