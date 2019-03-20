package ch.ny.schnuppertag;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ch.ny.berufsbildner.Berufsbildner;
import ch.ny.fachrichtung.Fachrichtung;
import ch.ny.ort.Ort;
import ch.ny.schnupperer.Schnupperer;

@Entity
@Table(name = "schnuppertag")
public class Schnuppertag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "ort_id")
	private Ort ort;
	
	@Column
	private int limit;
	
	@OneToMany
	@JoinColumn(name = "schnupperer_id")
	private Set<Schnupperer> participants;
	
	@ManyToOne
	@JoinColumn(name = "berufsbildner_id")
	private Berufsbildner director;
	
	@ManyToOne
	@JoinColumn(name = "fachrichtung_id")
	private Fachrichtung fachrichtung;
	
}
