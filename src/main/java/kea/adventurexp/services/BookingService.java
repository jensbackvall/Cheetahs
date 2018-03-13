package kea.adventurexp.services;


import kea.adventurexp.database.repos.BookingRepository;
import kea.adventurexp.database.repos.DeletedBookingRepository;
import kea.adventurexp.models.Booking;
import kea.adventurexp.models.DeletedBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class BookingService {

    @Autowired
    private DeletedBookingRepository deletedBookingRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public Booking addABooking(Booking aBooking) {
        Booking newBook = bookingRepository.save(aBooking);
        return newBook;
    }

    public Booking getABookingByEmail(String email){
        Booking booking = bookingRepository.findByEmail(email);
        return booking;
    }

    public Booking getABookingById(long id){
        return bookingRepository.getOne(id);
    }

    public void deleteABooking(Booking booking){

        DeletedBooking deletedBooking = new DeletedBooking();
        deletedBooking.setActivity(booking.getActivity());
        deletedBooking.setDate(booking.getDate());
        deletedBooking.setEmail(booking.getEmail());
        deletedBooking.setFirstName(booking.getFirstName());
        deletedBooking.setLastName(booking.getLastName());
        deletedBooking.setNumberOfAttendees(booking.getNumberOfAttendees());
        deletedBookingRepository.save(deletedBooking);
        bookingRepository.delete(booking);
    }

}
