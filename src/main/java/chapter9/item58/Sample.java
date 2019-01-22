package chapter8.item58;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        // 1) 전통적인 방법
        List<String> list = Arrays.asList("test", "test2", "test3");

        // 1-1) 컬렉션 순회
        for (Iterator<String> i = list.iterator(); ((Iterator) i).hasNext(); ) {
            String e = i.next();
            System.out.println(e);
        }

        String[] array = {"test", "test2", "tset3"};

        // 1-2) 배열 순회
        for (int i = 0; i < array.length; i++) {
            // array[i]로 무언가를 한다.
        }

        // 2) 컬렉션과 배열을 순회하는 올바른 관용구 (컬렉션, 배열을 구분 안해도 된다.)
        for (String str : list) {
            System.out.println(str);
        }

        for (String str : array) {
            System.out.println(str);
        }
    }
}
