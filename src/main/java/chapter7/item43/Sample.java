package chapter7.item43;

public class Sample {
    public static void main(String[] args) {

    }
}

interface G1 {
    <E extends Exception> Object m() throws E;
}

interface G2 {
    <F extends Exception> String m() throws Exception;
}

interface G extends G1, G2 {
    //<F extends Exception> () -> String throws F
}

