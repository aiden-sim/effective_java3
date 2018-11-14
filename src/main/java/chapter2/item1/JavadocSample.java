package chapter2.item1;

/**
 * Created by simjunbo on 2018-11-15.
 */
public class JavadocSample {
    private String name;

    /**
     * 이름을 받는 생성자
     *
     * @param name
     */
    public JavadocSample(String name) {
        this.name = name;
    }

    /**
     * 정적 팩토리 메서드
     *
     * @param name
     * @return JavadocSample
     */
    public static JavadocSample getName(String name) {
        return new JavadocSample(name);
    }

    /**
     * 정적 메서드
     * @param name
     * @return String
     */
    public static String getName2(String name) {
        return name;
    }

}
