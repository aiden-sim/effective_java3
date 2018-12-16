package chapter4.item18.properties;

import java.io.*;
import java.util.Properties;

public class PropertyUtil {
    private Properties prop = new Properties();

    public void save() {
        prop.setProperty("SERVER_IP", "127.0.0.1");
        prop.setProperty("SERVER_PORT", "5000");
        try {
            OutputStream stream = new FileOutputStream("properties.txt");
            prop.store(stream, "Server Info");
            stream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void change() {
        prop.put("SERVER_IP", "127.0.0.2");
        prop.setProperty("SERVER_PORT", "6000");
        try {
            OutputStream stream = new FileOutputStream("properties.txt");
            prop.store(stream, "Server Info Chnage");
            stream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void load() {
        try {
            Properties prop = new Properties();
            InputStream stream = new FileInputStream("properties.txt");
            prop.load(stream);
            stream.close();
            System.out.println("SERVER_IP=" + prop.get("SERVER_IP"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PropertyUtil util = new PropertyUtil();
        util.save();
        util.change();
        util.load();
    }
}
