package chapter2.item5;

import java.util.Objects;

/**
 * Created by simjunbo on 2018-11-18.
 */
public class SpellChecker {
    // 불변
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        return dictionary.isValid(word);
    }

    public static void main(String[] args) {
        SpellChecker checker = new SpellChecker(new Donga());
        boolean result = checker.isValid("자바");
        System.out.println(result);

        checker = new SpellChecker(new Doosan());
        result = checker.isValid("자바");
        System.out.println(result);

    }
}
