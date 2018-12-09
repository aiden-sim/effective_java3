package chapter3.item14.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Sarah", 10));
        humans.add(new Human("Jack", 12));

        // comparing
        Collections.sort(
                humans, Comparator.comparing(Human::getName));

        Collections.sort(
                humans, Comparator.comparing(Human::getName, String::compareTo));
    }
}
