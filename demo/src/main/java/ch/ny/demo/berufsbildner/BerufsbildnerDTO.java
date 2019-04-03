package ch.ny.demo.berufsbildner;

import ch.ny.demo.role.RoleDTO;

//abgespeckte version von entität
//ohne business logic, nur die daten die man braucht

public class BerufsbildnerDTO {

	private String firstName;
	
	private String lastName;
	
	private RoleDTO role;
	
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

	public RoleDTO getRole() {
		return role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}
		
}
