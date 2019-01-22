package chapter9.item60;

public class Sample {
    public static void main(String[] args) {
        // 0.61을 예상했지만 0.6100000000000001 를 출력한다.
        System.out.println(1.03 - 0.42);

        // 오류 발생! 금융 계산에 부동소수 타입을 사용
        /*
        double funds = 1.00;
        int itemsBought = 0;
        for (double price = 0.10; funds >= price; price += 0.10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + "개 구입");
        System.out.println("잔돈(달러):" + funds);
        */

        // BigDecimal은 정확하나 속도가 느리고 쓰기 불편한다.
        /*
        final BigDecimal TEN_CENTS = new BigDecimal(".10");
        int itemsBought = 0;
        BigDecimal funds = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
            funds = funds.subtract(price);
            itemsBought++;
        }
        System.out.println(itemsBought + "개 구입");
        System.out.println("잔돈(달러):" + funds);
        */

        // 정수 타입을 사용한 해법
        int itemsBought = 0;
        int funds = 100;
        for (int price = 10; funds >= price; price += 10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + "개 구입");
        System.out.println("잔돈(센트): " + funds);
    }
}
