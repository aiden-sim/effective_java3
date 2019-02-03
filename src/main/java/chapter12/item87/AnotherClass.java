package chapter12.item87;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AnotherClass implements Serializable {

    private static final long serialVersionUID = -5606842333916087978L;

    private String propertyOne;
    private transient String propertyTwo;

    public AnotherClass(String propertyOne, String propertyTwo) {
        this.propertyOne = propertyOne;
        this.propertyTwo = propertyTwo;
    }

    private void writeObject(ObjectOutputStream o)
            throws IOException {
        o.defaultWriteObject();
        o.writeObject(propertyTwo);
    }

    private void readObject(ObjectInputStream o)
            throws IOException, ClassNotFoundException {
        o.defaultReadObject();
        propertyTwo = (String) o.readObject();
    }

    public String getPropertyOne() {
        return propertyOne;
    }

    public String getPropertyTwo() {
        return propertyTwo;
    }

}