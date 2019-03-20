package ch.ny.schnupperer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ch.ny.ort.Ort;
import ch.ny.person.Person;

@Entity
@Table(name = "schnupperer")
public class Schnupperer extends Person {
	
	@Column
	private String email;
	
	@Column
	private String telephone;
	
	@ManyToOne
	@JoinColumn(name = "ort_id")
	private Ort ort;
	
}
