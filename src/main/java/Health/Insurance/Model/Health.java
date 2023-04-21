package Health.Insurance.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Health {
	@Id
	private int policynumber;
	private String firstName;
	private String lastName;
	private int phoneNumber;
	private String category;
	private String gender;
	
	public int getPolicynumber() {
		return policynumber;
	}
	public void setPolicynumber(int policynumber) {
		this.policynumber = policynumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Health(int policynumber, String firstName, String lastName, int phoneNumber, String category,
			String gender) {
		super();
		this.policynumber = policynumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.category = category;
		this.gender = gender;
	}
	public Health() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
