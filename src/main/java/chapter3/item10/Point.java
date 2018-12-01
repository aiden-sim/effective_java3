package chapter3.item10;

import java.awt.*;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 추이성 테스트
 */
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;

        Point p = (Point) o;
        return p.x == x && p.y == y;
    }
    */

    // CASE4 (리스코프 치환 법치 위배)
    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass())
            return false;
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    public static void main(String[] args) {
        // CASE1 (대칭성)
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);

        if (p.equals(cp)) {
            System.out.println("p와 cp는 같다.");
        }

        // 대칭성 문제
        if (cp.equals(p)) {
            System.out.println("cp와 p는 같다.");
        }

        // CASE2 (추이성)
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);

        if (p1.equals(p2)) {
            System.out.println("p1과 p2는 같다.");
        }

        if (p2.equals(p3)) {
            System.out.println("p2와 p3는 같다.");
        }

        // 추이성 문제
        if (p3.equals(p1)) {
            System.out.println("p3와 p1은 같다.");
        }

        /*
        // CASE3 (무한재귀)
        ColorPoint myColor = new ColorPoint(1, 2, Color.RED);
        SmellPoint mySmell  = new SmellPoint(1, 2, "test");

        // 무한 재귀에 빠진다.
        if(myColor.equals(mySmell)) {

        }
        */
    }
}
/*
class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    *//*
    // CASE1
    // equals를 작성 안하면 Point의 equals를 사용하게 되고 색상정보 (Color)는 무시하게 된다.
    // 하지만 해당 equals는 대칭성 위배가 된다.
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;

        return super.equals(o) && ((ColorPoint) o).color == color;
    }
    *//*

    // CASE2
    // 대칭성은 지켜지지만, 추이성이 깨진다.
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;

        // o가 Point면 색상을 무시하고 비교
        if (!(o instanceof ColorPoint))
            return o.equals(this);

        return super.equals(o) && ((ColorPoint) o).color == color;
    }
}*/

/**
 * CASE3
 * 무한재귀에 빠질 수 있다.
 */
class SmellPoint extends Point {
    private final String smell;

    public SmellPoint(int x, int y, String smell) {
        super(x, y);
        this.smell = smell;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;

        // o가 Point면 색상을 무시하고 비교
        if (!(o instanceof SmellPoint))
            return o.equals(this);

        return super.equals(o) && ((SmellPoint) o).smell == smell;
    }
}

class CounterPoint extends Point {
    private static final AtomicInteger counter = new AtomicInteger();

    public CounterPoint(int x, int y) {
        super(x, y);
        counter.incrementAndGet();
    }

    public static int numberCreated() {
        return counter.get();
    }
}


/**
 * 상속 대신 컴포지션
 */
class ColorPoint {
    private final Point point;
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    /**
     * 이 ColorPoint의 Point 뷰를 반환한다.
     */
    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;

        ColorPoint cp = (ColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    @Override
    public int hashCode() {
        return 31 * point.hashCode() + color.hashCode();
    }
}