package kea.adventurexp.services;


import kea.adventurexp.database.repos.BookingRepository;
import kea.adventurexp.models.Booking;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BookingRepositoryTest {

    @Autowired
    private BookingService bookingService;


    @Test
    public void findByEmailTest(){

        Booking booking = new Booking();
        booking.setFirstName("test");
        booking.setLastName("Hansen");
        booking.setEmail("testtest");
        booking.setDate("03-07-2018 12:00");

        bookingService.addABooking(booking);

        long id = 1;
        Booking foundBooking = bookingService.getABookingByEmail("testtest");

        assertEquals("testtest" , foundBooking.getEmail());
        bookingService.deleteABooking(foundBooking);
    }

    @Test
    public void deleteABookingTest(){
        Booking booking = new Booking();
        booking.setFirstName("Emil");
        booking.setEmail("testtesttest");
        booking.setDate("03-07-2018 12:00");

        bookingService.addABooking(booking);

        Booking retrievedBooking = bookingService.getABookingByEmail("testtesttest");
        assertEquals("Emil", retrievedBooking.getFirstName());

        bookingService.deleteABooking(retrievedBooking);

        Booking isNull = bookingService.getABookingByEmail("testtesttest");

        assertNull(isNull);


    }


}
