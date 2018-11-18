package chapter2.item5;

/**
 * Created by simjunbo on 2018-11-18.
 */
public class Doosan implements Lexicon {
    @Override
    public boolean isValid(String word) {
        if ("자바".equals(word)) {
            return true;
        }

        return false;
    }
}
