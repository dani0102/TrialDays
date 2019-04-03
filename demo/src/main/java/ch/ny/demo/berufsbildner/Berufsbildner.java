package ch.ny.demo.berufsbildner;

import javax.persistence.Entity;
import javax.persistence.Table;

import ch.ny.demo.person.Person;

@Entity
@Table(name = "berufsbildner")
public class Berufsbildner extends Person {

	public Berufsbildner() {
		super();
	}

	public Berufsbildner(long id, String firstName, String lastName, String username, String password) {
		super(id, firstName, lastName, username, password);
	}

	public Berufsbildner(String firstName, String lastName, String username, String password) {
		super(firstName, lastName, username, password);
	}

}
