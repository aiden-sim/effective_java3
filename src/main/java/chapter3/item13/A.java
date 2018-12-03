package chapter3.item13;

/**
 * clone을 override 하지 않았다.
 */
public class A implements Cloneable {
    private String name;
    private int age;

    public A(String name, int age) {
        this.name = name;
        this.age = age;
    }

/*    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/
}

class B extends A {
    public B(String name, int age) {
        super(name, age);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        B b = new B("심준보", 33);
        B b2 = (B) b.clone();
    }
}