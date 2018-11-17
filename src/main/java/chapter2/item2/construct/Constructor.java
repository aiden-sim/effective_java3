package chapter2.item2.construct;

/**
 * Created by simjunbo on 2018-11-17.
 */
public class Constructor {
    private String name;
    private Integer age;
    private String tel;
    private String address;

    public Constructor(String name, Integer age, String tel, String address) {
        this.name = name;
        this.age = age;
        this.tel = tel;
        this.address = address;
    }

    public Constructor(String name, Integer age, String tel) {
        this.name = name;
        this.age = age;
        this.tel = tel;
    }
}
