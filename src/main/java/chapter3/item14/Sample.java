package chapter3.item14;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sample {
    public static void main(String[] args) {
        BigDecimal bd1 = new BigDecimal("1.0");
        BigDecimal bd2 = new BigDecimal("1.00");

        Set<BigDecimal> hashSet = new HashSet<>();
        Set<BigDecimal> treeSet = new TreeSet<>();

        if (bd1.equals(bd2)) {
            System.out.println("bd1과 bd2의 equals는 같다.");
        }

        if (bd1.compareTo(bd2) == 0) {
            System.out.println("bd1과 bd2의 compareTo 는 같다.");
        }

        hashSet.add(bd1);
        hashSet.add(bd2);
        System.out.println(hashSet.size()); // size : 2

        treeSet.add(bd1);
        treeSet.add(bd2);
        System.out.println(treeSet.size()); // size : 1
    }
}

