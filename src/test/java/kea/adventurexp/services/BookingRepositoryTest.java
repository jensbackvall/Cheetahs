package kea.adventurexp.services;


import kea.adventurexp.database.repos.BookingRepository;
import kea.adventurexp.models.Booking;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookingRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private BookingRepository bookingRepository;

    @Test
    public void findByEmailTest(){

        Booking booking = new Booking();
        booking.setFirstName("Emil");
        booking.setLastName("Hansen");
        booking.setEmail("Hans@gmail.com");

        testEntityManager.persist(booking);

        long id = 1;
        Booking foundBooking = bookingRepository.findByEmail("Hans@gmail.com");

        assertEquals("Hans@gmail.com" , foundBooking.getEmail());
    }


}
