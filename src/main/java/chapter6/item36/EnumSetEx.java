package chapter6.item36;

import org.apache.commons.collections4.CollectionUtils;

import java.util.EnumSet;

public class EnumSetEx {
    public static final int STYLE_BOLD = 1 << 0;            // 1
    public static final int STYLE_ITALIC = 1 << 1;          // 2
    public static final int STYLE_UNDERLINE = 1 << 2;       // 4
    public static final int STYLE_STRIKETHROUGH = 1 << 3;   // 8

    public enum Style {BOLD, ITALIC, UNDERLINE, STETHROUGH}

    public static void main(String[] args) {
        // 구식
        // 합집합
        int union = STYLE_BOLD | STYLE_STRIKETHROUGH;
        System.out.println(union); // 9

        // 교집합
        int result = STYLE_BOLD | STYLE_ITALIC;
        int result2 = STYLE_ITALIC | STYLE_UNDERLINE;
        System.out.println(result & result2); // 2

        // 차집합
        int difference = STYLE_BOLD | STYLE_ITALIC | STYLE_UNDERLINE;
        System.out.println(difference ^ STYLE_ITALIC); // 5


        // EnumSet
        // 합집합
        System.out.println(EnumSet.of(Style.BOLD, Style.ITALIC));

        // 교집합
        EnumSet intersection1 = EnumSet.of(Style.BOLD, Style.ITALIC);
        EnumSet intersection2 = EnumSet.of(Style.ITALIC, Style.UNDERLINE);
        System.out.println(CollectionUtils.intersection(intersection1, intersection2));

        // 차집합
        EnumSet<Style> difference1 = EnumSet.of(Style.BOLD, Style.ITALIC, Style.UNDERLINE);
        EnumSet<Style> difference2 = EnumSet.of(Style.ITALIC);
        System.out.println(CollectionUtils.removeAll(difference1, difference2));
    }
}
