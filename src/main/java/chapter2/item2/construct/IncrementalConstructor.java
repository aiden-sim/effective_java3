package chapter2.item2.construct;

/**
 * Created by simjunbo on 2018-11-17.
 */
public class IncrementalConstructor {
    private String name;
    private Integer age;
    private String tel;
    private String address;


    public IncrementalConstructor(String name, Integer age) {
        this(name, age, null, null);
    }

    public IncrementalConstructor(String name, Integer age, String tel) {
        this(name, age, tel, null);
    }

    public IncrementalConstructor(String name, Integer age, String tel, String address) {
        this.name = name;
        this.age = age;
        this.tel = tel;
        this.address = address;
    }


    public static void main(String[] args) {
        IncrementalConstructor info = new IncrementalConstructor("심준보", 33);
    }
}
