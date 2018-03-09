package kea.adventurexp.services;

import kea.adventurexp.database.repos.ActivityRepository;
import kea.adventurexp.models.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

//    @Override
//    public Activity findByName(String name) {
//        return activityRepository.findById(name);
//    }

    public void addActivity(Activity activity){
        activityRepository.save(activity);
    }

    public List<Activity> getAllActivities(){
        return activityRepository.findAll();
    }

    public Activity getAnActivity(String name) {
        return activityRepository.getOne(name);
    }


}
