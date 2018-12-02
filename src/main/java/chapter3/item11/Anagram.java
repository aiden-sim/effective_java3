package chapter3.item11;

public class Anagram {
    private String name;
    private String name2;

    public Anagram(String name, String name2) {
        this.name = name;
        this.name2 = name2;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Anagram)) {
            return false;
        }

        Anagram anagram = (Anagram) obj;
        return anagram.name.equals(name) && anagram.name2 == name2;
    }

    /*
    // 31을 곱하지 않을 경우, Anagram의 해시코드가 같아 진다.
    @Override
    public int hashCode() {
        int result = ((name == null) ? 0 : name.hashCode());
        result = result + ((name2 == null) ? 0 : name2.hashCode());
        return result;
    }
    */

    // 31을 곱하면 Anagram 이라 해도 해시코드가 달라진다.
    @Override
    public int hashCode() {
        int result = ((name == null) ? 0 : name.hashCode());
        result = 31 * result + ((name2 == null) ? 0 : name2.hashCode());
        return result;
    }

    public static void main(String[] args) {
        Anagram am1 = new Anagram("심준보", "장영운");
        Anagram am2 = new Anagram("장영운", "심준보");

        System.out.println(am1.hashCode() + ":" + am2.hashCode());
    }
}
