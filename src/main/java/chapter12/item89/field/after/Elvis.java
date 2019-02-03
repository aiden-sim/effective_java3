package chapter12.item89.field.after;

import java.io.Serializable;
import java.util.Arrays;

// 열거 타입 싱글턴 - 전통적인 싱글턴보다 우수하다.
public enum Elvis implements Serializable {
    INSTANCE;
    private String[] favoriteSongs = {"Hound Dog", "Heartbreak Hotel"};

    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }
}
