package chapter12.item87;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 출처 : https://www.byteslounge.com/tutorials/java-custom-serialization-example
 */
public class Main {
    public static void main(String[] args)
            throws Exception {

        AnotherClass testWrite = new AnotherClass("valueOne", "valueTwo");
        FileOutputStream fos = new FileOutputStream("testfile.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(testWrite);
        oos.flush();
        oos.close();

        AnotherClass testRead;
        FileInputStream fis = new FileInputStream("testfile.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        testRead = (AnotherClass) ois.readObject();
        ois.close();

        System.out.println("--Serialized object--");
        System.out.println("propertyOne: " + testWrite.getPropertyOne());
        System.out.println("propertyTwo: " + testWrite.getPropertyTwo());
        System.out.println("");
        System.out.println("--Read object--");
        System.out.println("propertyOne: " + testRead.getPropertyOne());
        System.out.println("propertyTwo: " + testRead.getPropertyTwo());
    }
}
