package ch.ny.schnupperer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.type.PostgresUUIDType;

import ch.ny.ort.Ort;
import ch.ny.person.Person;

@Entity
@Table(name = "schnupperer")
public class Schnupperer extends Person {

	public Schnupperer() {
		super();
	}

	public Schnupperer(long id, String firstName, String lastName, String email, String telephone, Ort ort) {
		super(id, firstName, lastName);
		this.email = email;
		this.telephone = telephone;
		this.ort = ort;
	}

	public Schnupperer(String firstName, String lastName, String email, String telephone, Ort ort) {
		super(firstName, lastName);
		this.email = email;
		this.telephone = telephone;
		this.ort = ort;
	}

	@Column
	private PostgresUUIDType uuid;
	
	@Column
	@NotBlank
	private String email;

	@Column
	@NotBlank
	private String telephone;

	@ManyToOne
	@JoinColumn(name = "ort_id")
	@NotNull
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

	public PostgresUUIDType getUuid() {
		return uuid;
	}

	public void setUuid(PostgresUUIDType uuid) {
		this.uuid = uuid;
	}

}
