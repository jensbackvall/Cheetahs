package kea.adventurexp.services;

import kea.adventurexp.models.Activity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class GetAllActivitiesTest {

    @Autowired
    private ActivityService activityService;

    @Test
    public void getAllActivitiesTest(){
        // evt. lav 2 tests og hav return på første test, som kan kaldes i test 2.
        Activity activity = new Activity();
        activity.setName("Climbing");
        activity.setDescription("Climb the mountain");
        activity.setLimitations("No physical handicaps");
        activity.setMinParticipants(1);
        activity.setMaxParticipants(15);
        activity.setMinAge(4);
        activity.setMaxAge(70);
        activity.setMinHeight(150);
        activity.setMaxHeight(250);
        activity.setMinWeight(40);
        activity.setMaxWeight(150);

        activityService.addActivity(activity);

        List<Activity> activityList = activityService.getAllActivities();

        assertEquals( "Climbing", activityList.get(0).getName());
        assertEquals( "Climb the mountain", activityList.get(0).getDescription());
        assertEquals( "No physical handicaps", activityList.get(0).getLimitations());
        assertEquals( 1, activityList.get(0).getMinParticipants());
        assertEquals( 15, activityList.get(0).getMaxParticipants());
        assertEquals( 4, activityList.get(0).getMinAge());
        assertEquals( 70, activityList.get(0).getMaxAge());
        assertEquals( 150, activityList.get(0).getMinHeight());
        assertEquals( 250, activityList.get(0).getMaxHeight());
        assertEquals( 40, activityList.get(0).getMinWeight());
        assertEquals( 150, activityList.get(0).getMaxWeight());
    }

}
