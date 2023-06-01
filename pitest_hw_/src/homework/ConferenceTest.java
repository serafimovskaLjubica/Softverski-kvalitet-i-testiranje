package homework;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ConferenceTest {

    private Conference conference;

    @Before
    public void setUp() {
        conference = new Conference(20); // Set the initial capacity to 10 for testing
    }

    @Test
    public void testCalculateTotalPricePaid_NoDiscount() {
        // Create some students without discounts
        Student student1 = new Student("John", "spectre", Course.OS, 20);
        Student student2 = new Student("Bube", "Serafimovska", Course.OTHER, 25);
        conference.addAttendeeToConference(student1);
        conference.addAttendeeToConference(student2);

        double expectedPrice = Conference.TICKET_PRICE * 2;
        double totalPrice = conference.calculateTotalPricePaid();

        assertEquals(expectedPrice, totalPrice, 0.01); // Using delta for double comparison
    }

    @Test
    public void testCalculateTotalPricePaid_EMTDiscount() {
        // Create a student with EMT discount
        Student student = new Student("Emily", "Johnson", Course.EMT, 22);
        conference.addAttendeeToConference(student);

        double expectedPrice = (1 - Conference.EMT_DISCOUNT) * Conference.TICKET_PRICE;
        double totalPrice = conference.calculateTotalPricePaid();

        assertEquals(expectedPrice, totalPrice, 0.01);
    }

    @Test
    public void testCalculateTotalPricePaid_WEBDiscount() {
        // Create a student with WEB discount
        Student student = new Student("Alex", "Davis", Course.WEB, 24);
        conference.addAttendeeToConference(student);

        double expectedPrice = (1 - Conference.WEB_DISCOUNT) * Conference.TICKET_PRICE;
        double totalPrice = conference.calculateTotalPricePaid();

        assertEquals(expectedPrice, totalPrice, 0.01);
    }

    @Test
    public void testAddAttendeeToConference_Success() {
        Student student = new Student("Alice", "Brown", Course.SKIT, 21);
        boolean added = conference.addAttendeeToConference(student);

        assertTrue(added);
        assertTrue(conference.getAttendees().contains(student));
    }


        @Test
    public void testTripleCapacity_Success() {
        int initialCapacity = conference.getCapacity();

        boolean tripled = conference.tripleCapacity();

        assertTrue(tripled);
        assertEquals(initialCapacity * 3, conference.getCapacity());
    }

    @Test
    public void testTripleCapacity_Overflow() {
        // Set the initial capacity to a value close to the maximum limit
        conference = new Conference(3333);

        boolean tripled = conference.tripleCapacity();
    }}
