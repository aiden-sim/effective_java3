package chapter6.item36.after;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class Text {
    public enum Style {BOLD, ITALIC, UNDERLINE, STETHROUGH}

    // 어떤 Set을 넘겨도 되나, EnumSet이 가장 좋다.
    public void applyStyles(Set<Style> styles) {
        System.out.printf("Applying styles %s to text%n",
                Objects.requireNonNull(styles));
    }

    // 사용 예
    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}

