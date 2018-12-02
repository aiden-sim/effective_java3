package chapter3.item11;

import chapter3.item10.PhoneNumber;

import java.util.HashMap;
import java.util.Map;

public class Sample {
    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(new PhoneNumber(707, 867, 5309), "제니");

        String result = m.get(new PhoneNumber(707, 867, 5309));
        System.out.println("result : " + result);
    }
}
