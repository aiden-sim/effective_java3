package chapter5.item28.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser<T> {
    //private final T[] choiceArray;
    private final List<T> choiceList;

    // 1) 첫시도 - 컴파일 되지 않는다.
    /*
    public Chooser(Collection<T> choices) {
        choiceArray = choices.toArray();
    }
    */

    // 2) 형변환은 되지만 컴파일 경고(unchecked)가 뜬다.
    /*
    public Chooser(Collection<T> choices) {
        choiceArray = (T[]) choices.toArray();
    }
    */

    public Chooser(Collection<T> choices) {
        choiceList = new ArrayList<>(choices);
    }

    /*
    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
    */
    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}
