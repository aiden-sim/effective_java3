package chapter2.item8.clean;

public class Adult {
    public static void main(String[] args) throws Exception {

        // 1) try-with-resources 를 이용한 해제
        try (Room myRoom = new Room(7)) {
            System.out.println("안뇽");
        }

        // 2) System.gc를 이용한 해제
        new Room(99);
        System.out.println("아무렴");
        System.gc();
    }
}
