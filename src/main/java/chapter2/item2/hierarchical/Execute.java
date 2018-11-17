package chapter2.item2.hierarchical;

import static chapter2.item2.hierarchical.NyPizza.Size.*;
import static chapter2.item2.hierarchical.Pizza.Topping.*;

/**
 * Created by simjunbo on 2018-11-17.
 */
public class Execute {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE)
                .addTopping(ONION)
                .build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM)
                .sauceInside()
                .build();

    }
}
