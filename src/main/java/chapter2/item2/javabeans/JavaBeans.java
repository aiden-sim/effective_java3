package chapter2.item2.javabeans;

/**
 * Created by simjunbo on 2018-11-17.
 */
public class JavaBeans {
    private String name;
    private Integer age;
    private String tel;
    private String address;

    public JavaBeans() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {
        JavaBeans info = new JavaBeans();
        info.setName("심준보");
        info.setAge(18);
        info.setTel("010-1234-1234");
    }
}
