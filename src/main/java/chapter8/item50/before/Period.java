package chapter8.item50.before;

import java.util.Date;

/**
 * 기간을 표현하는 클래스 - 불변식을 지키지 못했다.
 * Date가 가변이라면?
 */
public class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
        this.start = start;
        this.end = end;
    }

    public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }

    // 클라이언트에서 어택!
    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        end.setYear(78);
    }
}
