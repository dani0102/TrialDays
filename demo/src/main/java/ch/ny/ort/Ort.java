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
	
}
