package chapter2.item2.builder;

/**
 * Created by simjunbo on 2018-11-17.
 */
public class JavaBuilder {
    private final String name;
    private final Integer age;
    private final String tel;
    private final String address;

    private JavaBuilder(Builder builder) {
        name = builder.name;
        age = builder.age;
        tel = builder.tel;
        address = builder.address;
    }

    public static class Builder {
        // 필수 매개변수
        private final String name;
        private final Integer age;

        // 선택 매개변수
        private String tel = "";
        private String address = "";

        public Builder(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Builder tel(String tel) {
            this.tel = tel;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public JavaBuilder build() {
            JavaBuilder builder = new JavaBuilder(this);

            if (builder.age < 0) {
                throw new IllegalArgumentException("나이는 -가 될 수 없습니다.");
            }

            return builder;
        }
    }

    public static void main(String[] args) {
        JavaBuilder info = new Builder("심준보", 33)
                .tel("010-1234-1234")
                .address("서울시")
                .build();
    }
}
