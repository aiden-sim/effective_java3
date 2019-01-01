/**
 * C:\dev\EffectiveJava3\src\main\java>"C:\Program Files\Java\jdk1.8.0_20\bin\javac" -d . Foo.java
 *
 * C:\dev\EffectiveJava3\src\main\java>"C:\Program Files\Java\jdk1.8.0_20\bin\javac" -d . -classpath . Bar.java
 *
 * C:\dev\EffectiveJava3\src\main\java>"C:\Program Files\Java\jdk1.8.0_20\bin\java" -classpath . Bar
 */
public class Bar {
    public static void main(String[] args) {
        System.out.println(Foo.SOMETHING);
    }
}
