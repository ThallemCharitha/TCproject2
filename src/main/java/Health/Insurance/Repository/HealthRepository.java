package Health.Insurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Health.Insurance.Model.Health;
@Repository
public interface HealthRepository extends JpaRepository<Health, Integer> {

}
