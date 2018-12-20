package chapter4.item23.hierarchy;

public abstract class Figure {
    //1) 태그 값에 따라 동작이 달라지는 메서드들을 루트 클래스의 추상메서드로 선언
    abstract double area();
}

class Circle extends Figure {
    final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}

class Rectangle extends Figure {
    final double length;
    final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}
