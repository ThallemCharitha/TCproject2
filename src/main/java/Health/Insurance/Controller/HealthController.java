package Health.Insurance.Controller;

import java.security.PublicKey;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Health.Insurance.Model.Health;
import Health.Insurance.Service.HealthService;

@RestController
public class HealthController {
	@Autowired
	HealthService healthService;
	private static final Logger log = Logger.getLogger(HealthController.class);

	@GetMapping("/Details")
	public List<Health> getHealthDetails() {
		log.info("Browser logging");
		return healthService.getHealthDetails();
	}
	

	@GetMapping("/AllDetails")
	public ResponseEntity<List<Health>> healthDetails() {
		try {

			log.info("Getting the all details");
			List<Health> health = healthService.healthDetails();
			return new ResponseEntity<List<Health>>(health, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/DetailsById/{id}")
	public ResponseEntity<Health> DetailsById(@PathVariable(value = "id") int id) {
		try {
			log.info("Getting the details by ID");
			Health health = healthService.DetailsById(id);
			return new ResponseEntity<Health>(health, HttpStatus.FOUND);
		} catch (Exception e) {
			log.error("Error to get  details by ID");
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/Creating")
	public ResponseEntity<Health> Creating(@RequestBody Health health) {
		try {
			health = healthService.Creating(health);
			log.info("posting the details");
			return new ResponseEntity<Health>(health, HttpStatus.CREATED);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);

		}
	}

	@PutMapping("/updateHealthDetails/{Policynumber}")
	public ResponseEntity<Health> updateCard(@PathVariable(value = "Policynumber") int Policynumber,
			@RequestBody Health health) {
		try {
			log.info("Values Changed");

			Health existDetails = healthService.DetailsById(Policynumber);
			existDetails.setPolicynumber(health.getPolicynumber());
			existDetails.setFirstName(health.getFirstName());
			existDetails.setLastName(health.getLastName());
			existDetails.setPhoneNumber(health.getPhoneNumber());
			existDetails.setCategory(health.getCategory());
			existDetails.setGender(health.getGender());

			Health updateHealthDetails = healthService.updateHealthDetails(existDetails);
			return new ResponseEntity<Health>(updateHealthDetails, HttpStatus.OK);
		} catch (Exception e) {
			log.warn("Changing the values");
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);

	}

	@DeleteMapping("/cancelDetails/{Policynumber}")
	public ResponseEntity<Health> deleteHealthDetails(@PathVariable(value = "Policynumber") int Policynumber) {
		Health health = null;
		try {
			log.info("Deleting details");
			health = healthService.DetailsById(Policynumber);
			healthService.deleteHealthDetails(health);
			return new ResponseEntity<Health>(health, HttpStatus.OK);
		}

		catch (NoSuchElementException e) {
			log.error("Error to deleting details");
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}