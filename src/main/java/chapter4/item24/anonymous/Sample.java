package chapter4.item24.anonymous;

public class Sample {
    public static void main(String[] args) {
        Anonymous anonymous = new Anonymous() {

            @Override
            public void print() {
                System.out.println("anonymous class");
            }
        };

        anonymous.print();
    }
}
