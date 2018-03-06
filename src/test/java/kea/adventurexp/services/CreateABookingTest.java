package kea.adventurexp.services;


import kea.adventurexp.models.Booking;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CreateABookingTest {

    @Autowired
    private BookingService bookingService;

    @Test
    public void createABookingHappyPath() {

        //Create a booking
        Booking aBooking = new Booking();

        aBooking.setFirstName("John");
        aBooking.setLastName("Johnsen");
        aBooking.setEmail("JJ@gmail.com");
        aBooking.setActivity("GoKart");
        aBooking.setDate("2018-07-03 12:00");

        aBooking.setNumberOfAttendees(5);

        //test saving to db
        Booking newBooking = bookingService.addABooking(aBooking);

        //confirm data that is saved
        assertNotNull(newBooking.getId());
        assertEquals("John", newBooking.getFirstName());
        assertEquals("Johnsen", newBooking.getLastName());
        assertEquals("JJ@gmail.com", newBooking.getEmail());
        assertEquals("GoKart", newBooking.getActivity());
        assertEquals(5, newBooking.getNumberOfAttendees());
        assertEquals("2018-07-03T12:00", newBooking.getDate());
    }

    @Test
    public void setDateTest(){
        Booking booking = new Booking();
        booking.setDate("2018-07-03 12:00");
        assertEquals("2018-07-03T12:00", booking.getDate());
    }
}
