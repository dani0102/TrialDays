package ch.ny.berufsbildner;

import javax.persistence.Entity;
import javax.persistence.Table;

import ch.ny.person.Person;

@Entity
@Table(name = "berufsbildner")
public class Berufsbildner extends Person {

	public Berufsbildner() {
		super();
	}
	
}
