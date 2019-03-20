package ch.ny.ort;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ort")
public class Ort {

	public Ort() { }

	public Ort(String pLZ, String street, int number, String city, String region) {
		PLZ = pLZ;
		this.street = street;
		this.number = number;
		this.city = city;
		this.region = region;
	}
	
	public Ort(long id, String pLZ, String street, int number, String city, String region) {
		this.id = id;
		PLZ = pLZ;
		this.street = street;
		this.number = number;
		this.city = city;
		this.region = region;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String PLZ;
	
	@Column
	private String street;
	
	@Column
	private int number;
	
	@Column
	private String city;
	
	@Column
	private String region;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPLZ() {
		return PLZ;
	}

	public void setPLZ(String pLZ) {
		PLZ = pLZ;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	
}
