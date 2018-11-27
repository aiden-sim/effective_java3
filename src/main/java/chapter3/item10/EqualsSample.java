package chapter3.item10;

/**
 * equals 요건
 */
public class EqualsSample {
    public static void main(String[] args) {
        Vehicle x = new Vehicle("Focus", 2002, "Ford");
        Vehicle y = new Vehicle("Focus", 2002, "Ford");
        Vehicle z = new Vehicle("Focus", 2002, "Ford");

        // 반사성
        if (x.equals(x)) {
            System.out.println("It is reflexive!");
        } else {
            System.out.println("It is not reflexive");
        }

        // 대칭성
        if (x.equals(y) && y.equals(x)) {
            System.out.println("It is symmetric!");
        } else {
            System.out.println("It is not symmetric");
        }

        // 추이성
        if (x.equals(y) && y.equals(z) && z.equals(x)) {
            System.out.println("It is transitive!");
        } else {
            System.out.println("It is not transitive");
        }

        // 일관성
        for (int i = 0; i < 5; i++) {
            if (x.equals(y)) {
                System.out.println("It is consistency!");
            } else {
                System.out.println("It is not transitive");
            }
        }

        // null 아님
        if (x.equals(null) == false) {
            System.out.println("Nothing equals null");
        } else {
            System.out.println("An object equals null?!");
        }
    }
}
