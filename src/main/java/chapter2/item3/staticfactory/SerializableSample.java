package chapter2.item3.staticfactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by simjunbo on 2018-11-18.
 */
public class SerializableSample {
    public static void main(String[] args) {
        Elvis INSTANCE = Elvis.getInstance();

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("connectFactory.txt"));
            oos.writeObject(INSTANCE);
            oos.close();

            ObjectInputStream osi = new ObjectInputStream(new FileInputStream("connectFactory.txt"));
            Elvis factory1 = (Elvis) osi.readObject();
            osi.close();

            ObjectInputStream osi2 = new ObjectInputStream(new FileInputStream("connectFactory.txt"));
            Elvis factory2 = (Elvis) osi2.readObject();
            osi2.close();

            System.out.println("Object reference check->" + factory1.hashCode());
            System.out.println("Object reference check->" + factory2.hashCode());
        }catch(Exception i) {
            i.printStackTrace();
        }
    }
}
