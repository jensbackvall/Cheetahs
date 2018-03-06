package kea.adventurexp.controllers;

import kea.adventurexp.database.repos.ActivityRepository;
import kea.adventurexp.models.Activity;
import kea.adventurexp.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ActivityRepository activityRepository;

    @RequestMapping(value = "/viewActivities", method = RequestMethod.GET)
    public String showAllActivites(Model model){
        model.addAttribute("allActivities", activityService.getAllActivities());
//        activityService.getAllActivities();
        return "viewActivities";
    }
}
