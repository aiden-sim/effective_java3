package chapter8.item52;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample {
    public static void main(String[] args) {
        // 1번 Thread의 생성자 호출
        new Thread(System.out::println).start();

        // 2번 ExecutorService의 submit 메서드 호출
        //ExecutorService exec = Executors.newCachedThreadPool();
        //exec.submit(System.out::println);
    }
}
