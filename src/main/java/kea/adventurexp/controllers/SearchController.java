package kea.adventurexp.controllers;

import kea.adventurexp.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

    @Autowired
    BookingService bookingService;

    @RequestMapping(value = "/searchForBooking", method = RequestMethod.GET)
    public String searchABooking(){
        return "searchForBooking";
    }

    @RequestMapping(value="/searchForBooking", method = RequestMethod.POST)
    public ModelAndView returnABooking(Model model, String email){

        model.addAttribute("booking", bookingService.getABookingByEmail(email));

        return new ModelAndView("SearchForBookingResult", "bookingDetails", model);
    }

}
