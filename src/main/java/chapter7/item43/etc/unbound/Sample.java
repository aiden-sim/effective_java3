package chapter7.item43.etc.unbound;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

public class Sample {
    public static void main(String[] args) {
        List<Child> list = new ArrayList<>();
        list.add(new Child("dog", 1));
        list.add(new Child("cat", 1));

        Function<Child, String> function = (a) -> a.getName();
        Function<Child, String> function2 = Child::getName;

        String name = list.stream()
                .map(function2)
                .findAny().get();

<<<<<<< HEAD
		System.out.println(name);

		ExecutorService exec = Executors.newSingleThreadExecutor();
	}
=======
        System.out.println(name);
    }
>>>>>>> c7aa3b0e791bbcaf95166464f36b96923bc41d96

    private static class Child {
        private String name;

        private int age;

        public Child(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }
}
