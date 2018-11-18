package chapter2.item3.lazyholder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by simjunbo on 2018-11-18.
 */
public class Reflection {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Elvis elvis = Elvis.getInstance();
        Elvis elvis2 = null;

        Constructor[] constructors = Elvis.class.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            constructor.setAccessible(true);
            elvis2 = (Elvis) constructor.newInstance();
        }
    }
}
