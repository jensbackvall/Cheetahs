package kea.adventurexp.database.repos;

import kea.adventurexp.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository("activityRepository")
public interface ActivityRepository extends JpaRepository<Activity, String> {
//    Activity findByName(String name);
}
