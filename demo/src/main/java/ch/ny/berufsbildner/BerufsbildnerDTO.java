package ch.ny.berufsbildner;

public class BerufsbildnerDTO {

	private String firstName;
	private String lastName;
	
	public BerufsbildnerDTO() { }
	
	public BerufsbildnerDTO(String firstname, String lastname) {
		this.firstName = firstname;
		this.lastName = lastname;
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
		
}
