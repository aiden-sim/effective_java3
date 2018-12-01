package chapter3.item10;

import java.sql.Timestamp;
import java.util.Date;

public class DateSample {
    public static void main(String[] args) {
        Date date = new Date();
        Date stamp = new Timestamp(date.getTime());

        System.out.println(date.equals(stamp));
        // 대칭성 위배된다.
        System.out.println(stamp.equals(date));
        System.out.println(date.compareTo(stamp) == 0);
        System.out.println(stamp.compareTo(date) == 0);
    }
}
