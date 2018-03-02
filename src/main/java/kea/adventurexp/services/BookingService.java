package kea.adventurexp.services;


import kea.adventurexp.database.repos.BookingRepository;
import kea.adventurexp.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking addABooking(Booking aBooking) {
        Booking newBook = bookingRepository.save(aBooking);
        return newBook;
    }
}
