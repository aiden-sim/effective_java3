package chapter4.item18.properties;

import java.util.Properties;

public class Sample {
    public static void main(String[] args) {
        User user = new User("simjunbo", 33);

        Properties properties = new Properties();
        properties.put("simjunbo", user);

        User result = (User) properties.get("simjunbo");
        System.out.println(result);
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ":" + age;
    }
}