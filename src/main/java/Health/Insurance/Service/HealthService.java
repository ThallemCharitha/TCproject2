package Health.Insurance.Service;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Health.Insurance.Model.Health;
import Health.Insurance.Repository.HealthRepository;

@Service
public class HealthService {

	@Autowired
	private HealthRepository healthRepo;
	
	private static final Logger log = Logger.getLogger(HealthService.class);
	
	public List<Health> getHealthDetails(){
		log.info("inside getHealthDetails() method");
		return Arrays.asList(new Health(1,"thallem","charitha",54655564,"eye","female"));
	}

	public List<Health> healthDetails() {
		List<Health>health=healthRepo.findAll();
		return health;
	}

	public Health DetailsById(int Policynumber) {
		
		return healthRepo.findById(Policynumber).get();
	}
	public  Health Creating(Health health) {
		healthRepo.save(health);
		return health;
	}

	public Health updateHealthDetails(Health health) {
		healthRepo.save(health);
		return health;
	}
		
	public void deleteHealthDetails(Health health) {
		healthRepo.delete(health);

	}


}
