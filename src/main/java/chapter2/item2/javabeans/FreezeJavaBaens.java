package chapter2.item2.javabeans;

/**
 * Created by simjunbo on 2018-11-17.
 */
public class FreezeJavaBaens {
    private String name;
    private Integer age;
    private String tel;
    private String address;

    private boolean frozen;

    public FreezeJavaBaens() {
    }

    public synchronized void setName(String name) {
        checkNotFrozen();
        this.name = name;
    }

    public synchronized void setAge(Integer age) {
        checkNotFrozen();
        this.age = age;
    }

    public synchronized void setTel(String tel) {
        checkNotFrozen();
        this.tel = tel;
    }

    public synchronized void setAddress(String address) {
        checkNotFrozen();
        this.address = address;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public synchronized void freeze() {
        frozen = true;
    }

    private void checkNotFrozen() {
        if (frozen) throw new RuntimeException();
    }

    public static void main(String[] args) {
        FreezeJavaBaens info = new FreezeJavaBaens();
        info.setName("심준보");
        info.setAge(18);
        info.setTel("010-1234-1234");
        info.freeze();

        if (info.isFrozen()) {
            // 얼린 후에 사용
        }
    }
}
