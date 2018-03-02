package kea.adventurexp.controllers;

import kea.adventurexp.models.Booking;
import kea.adventurexp.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "/createABooking", method = RequestMethod.GET)
    public String createABooking(){
        return "createABooking";
    }

    @RequestMapping(value = "/createABooking", method = RequestMethod.POST)
    public String createABooking(Booking booking){
//        System.out.println(booking.getFirstName());
//        System.out.println(booking.getLastName());
//        System.out.println(booking.getEmail());
//        System.out.println(booking.getNumberOfAttendees());
//        System.out.println(booking.getActivity());
//        booking.setActivity("Climbing");

        bookingService.addABooking(booking);
//        BookingService bs = new BookingService();
//        bs.addABooking(booking);
        return "createABooking";
    }
}
