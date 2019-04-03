package ch.ny.demo.schnupperer;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import ch.ny.demo.ort.Ort;
import ch.ny.demo.person.Person;

@Entity
@Table(name = "schnupperer")
public class Schnupperer extends Person {

	public Schnupperer() {
		super();
	}

	public Schnupperer(long id, String firstName, String lastName, String email, String telephone, Ort ort, String username, String password) {
		super(id, firstName, lastName, username, password);
		this.email = email;
		this.telephone = telephone;
		this.ort = ort;
	}

	public Schnupperer(String firstName, String lastName, String email, String telephone, Ort ort, String username, String password) {
		super(firstName, lastName, username, password);
		this.email = email;
		this.telephone = telephone;
		this.ort = ort;
	}

	@Column
	private UUID uuid;
	
	@Column
	@NotBlank
	private String email;

	@Column
	@NotBlank
	private String telephone;

	@ManyToOne
	@JoinColumn(name = "ort_id")
	//@NotNull
	private Ort ort;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Ort getOrt() {
		return ort;
	}

	public void setOrt(Ort ort) {
		this.ort = ort;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

}