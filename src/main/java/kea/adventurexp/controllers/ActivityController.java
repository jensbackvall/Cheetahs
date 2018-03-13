package kea.adventurexp.controllers;

import kea.adventurexp.database.repos.ActivityRepository;
import kea.adventurexp.models.Activity;
import kea.adventurexp.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("theActivity", activityService.getAllActivities().get(0));
        return "viewActivities";
    }

    @RequestMapping(value = "/viewActivities/{name}", method = RequestMethod.GET)
    public String showAllActivites(@PathVariable String name, Model model){
        model.addAttribute("allActivities", activityService.getAllActivities());
        Activity theActivity = activityService.getAnActivity(name);
        model.addAttribute("theActivity", theActivity);
        return "viewActivities";
    }

    @RequestMapping(value = "/admin/activities/createNewActivity", method = RequestMethod.GET)
    public String createNewActivity(Model model){
        model.addAttribute("allActivities", activityService.getAllActivities());
        model.addAttribute("theActivity", activityService.getAllActivities().get(0));
        return "/admin/activities/createNewActivity";
    }

    @RequestMapping(value = "/admin/activities/createNewActivity", method = RequestMethod.POST)
    public String createNewActivity(Activity activity, Model model){
        model.addAttribute("allActivities", activityService.getAllActivities());
        model.addAttribute("succesMessage", "Du har oprettet en ny aktivitet.GODT GÅET! PIZZA!");
        activityService.addActivity(activity);
        return "/admin/activities/createNewActivity";
    }

    @RequestMapping(value = "/admin/activities/editExistingActivity/{name}", method = RequestMethod.GET)
    public String editActivity(@PathVariable String name, Model model){
        model.addAttribute("allActivities", activityService.getAllActivities());
        Activity theActivity = activityService.getAnActivity(name);
        model.addAttribute("theActivity", theActivity);
        return "/admin/activities/editExistingActivity";
    }

    @RequestMapping(value = "/admin/activities/editExistingActivity", method = RequestMethod.POST)
    public String editActivity(Activity activity, Model model){
        model.addAttribute("allActivities", activityService.getAllActivities());
        activityService.addActivity(activity);
        model.addAttribute("succesMessage", "Du har redigeret aktiviteten.GODT GÅET! PIZZA!");
        return "redirect:/admin/activities/editExistingActivity/" + activity.getName();
    }

}
