package chapter6.item41;

import java.lang.reflect.Method;

public class Marker {

    public static void method(MarkerInterface mi) {
        System.out.println("마커 인터페이스");
    }

    public static void method(Object mi) throws Exception {
        if (mi instanceof MarkerInterface) {
            System.out.println("마커 인터페이스");
        } else {
            System.out.println("마커 인터페이스 아닙니다.");
        }
    }

    @MarkerAnnotation
    public static void method() {
        Marker obj = new Marker();
        try {
            Method m = obj.getClass().getMethod("method");

            if (m.isAnnotationPresent(MarkerAnnotation.class)) {
                System.out.println("마커 애너테이션");
            } else {
                System.out.println("마커 애너테이션이 아닙니다.");
            }
        } catch (NoSuchMethodException exc) {
            System.out.println("Method not found..!!");
        }
    }

    public static void method2() {
        Marker obj = new Marker();
        try {
            Method m = obj.getClass().getMethod("method2");

            if (m.isAnnotationPresent(MarkerAnnotation.class)) {
                System.out.println("마커 애너테이션");
            } else {
                System.out.println("마커 애너테이션이 아닙니다.");
            }
        } catch (NoSuchMethodException exc) {
            System.out.println("Method not found..!!");
        }
    }

    public static void main(String args[]) throws Exception {
        method(new ConcreteClass());
        method(new ConcreteClass2());

        method();
        method2();
    }
}