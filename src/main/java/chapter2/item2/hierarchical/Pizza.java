package chapter2.item2.hierarchical;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by simjunbo on 2018-11-17.
 */
public abstract class Pizza {
    public enum Topping {
        HAN, MUSHROOM, ONION, PEPPER, SAUSAGE
    }

    final Set<Topping> toppings;

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        protected abstract T self();
    }


}
