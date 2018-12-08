package chapter3.item13;

/**
 * 복사 생성자 예제
 * 출처 : http://www.javapractices.com/topic/TopicAction.do?Id=12
 */
public final class Galaxy {

    /**
     * Regular constructor.
     */
    public Galaxy(Double mass, String name) {
        this.mass = mass;
        this.name = name;
    }

    /**
     * Copy constructor.
     */
    public Galaxy(Galaxy galaxy) {
        this(galaxy.getMass(), galaxy.getName());
        //no defensive copies are created here, since
        //there are no mutable object fields (String is immutable)
    }

    /**
     * Alternative style for a copy constructor, using a static newInstance
     * method.
     */
    public static Galaxy newInstance(Galaxy galaxy) {
        return new Galaxy(galaxy.getMass(), galaxy.getName());
    }

    public Double getMass() {
        return mass;
    }

    /**
     * This is the only method which changes the state of a Galaxy
     * object. If this method was removed, then a copy constructor
     * would not be provided either, since immutable objects do not
     * need a copy constructor.
     */
    public void setMass(Double aMass) {
        mass = aMass;
    }

    public String getName() {
        return name;
    }

    // PRIVATE

    /**
     * Using Double instead of BigDecimal here: the context is scientific!
     */
    private Double mass;
    private final String name;

    /**
     * Test harness.
     */
    public static void main(String... args) {
        Galaxy m101 = new Galaxy(15.0, "M101");

        Galaxy m101CopyOne = new Galaxy(m101);
        m101CopyOne.setMass(25.0);

        Galaxy m101CopyTwo = Galaxy.newInstance(m101);
        m101CopyTwo.setMass(35.0);

        log("M101 mass: " + m101.getMass());
        log("M101CopyOne mass: " + m101CopyOne.getMass());
        log("M101CopyTwo mass: " + m101CopyTwo.getMass());
    }

    private static void log(String msg) {
        System.out.println(msg);
    }
}