package kea.adventurexp.database.repos;

import kea.adventurexp.models.DeletedBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeletedBookingRepository extends JpaRepository<DeletedBooking, Long> {
}
