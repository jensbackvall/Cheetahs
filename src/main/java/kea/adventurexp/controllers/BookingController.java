package kea.adventurexp.controllers;

import kea.adventurexp.models.Booking;
import kea.adventurexp.services.ActivityService;
import kea.adventurexp.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Book;

@Controller
public class BookingController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "/createABooking", method = RequestMethod.GET)
    public ModelAndView createABooking(Model model){
        model.addAttribute("listOfActivities", activityService.getAllActivities());
        return new ModelAndView("createABooking", "model", model) ;
    }

    @RequestMapping(value = "/createABooking", method = RequestMethod.POST)
    public String createABooking(Booking booking){
        System.out.println(booking.getFirstName());
        bookingService.addABooking(booking);
        return "createABooking";
    }

    @RequestMapping(value = "/editABooking", method = RequestMethod.GET)
    public ModelAndView editABooking(@RequestParam("bookingId") long bookingId, Model model){
        model.addAttribute("booking" ,bookingService.getABookingById(bookingId));
        return new ModelAndView("editABooking", "bookingDetails", model);
    }

    @RequestMapping(value = "/editABooking", method = RequestMethod.POST)
    public String saveEditBooking(Booking booking, @RequestParam("id") long id){
        Booking updateBooking = bookingService.getABookingById(id);

        updateBooking.setFirstName(booking.getFirstName());
        updateBooking.setLastName(booking.getLastName());
        updateBooking.setEmail(booking.getEmail());
        updateBooking.setDate(booking.getDate());
        updateBooking.setActivity(booking.getActivity());
        updateBooking.setNumberOfAttendees(booking.getNumberOfAttendees());
        bookingService.addABooking(updateBooking);
        return "index";
    }

    @RequestMapping(value="/deleteABooking", method = RequestMethod.POST)
    public String deleteABooking(@RequestParam("id") long id){
        Booking booking = bookingService.getABookingById(id);
        bookingService.deleteABooking(booking);
        return "index";
    }

}
