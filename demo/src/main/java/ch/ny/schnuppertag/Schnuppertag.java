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
import javax.validation.constraints.NotNull;

import ch.ny.berufsbildner.Berufsbildner;
import ch.ny.fachrichtung.Fachrichtung;
import ch.ny.ort.Ort;
import ch.ny.schnupperer.Schnupperer;

@Entity
@Table(name = "schnuppertag")
public class Schnuppertag {

	public Schnuppertag() { }

	public Schnuppertag(Date date, Ort ort, int limit, Set<Schnupperer> participants, Berufsbildner director, Fachrichtung fachrichtung) {
		this.date = date;
		this.ort = ort;
		this.limit = limit;
		this.participants = participants;
		this.director = director;
		this.fachrichtung = fachrichtung;
	}
	
	public Schnuppertag(long id, Date date, Ort ort, int limit, Set<Schnupperer> participants, Berufsbildner director, Fachrichtung fachrichtung) {
		this.id = id;
		this.date = date;
		this.ort = ort;
		this.limit = limit;
		this.participants = participants;
		this.director = director;
		this.fachrichtung = fachrichtung;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;

	@Column
	@NotNull
	private Date date;

	@ManyToOne
	@JoinColumn(name = "ort_id")
	@NotNull
	private Ort ort;

	@Column(name = "limits")
	@NotNull
	private int limit;

	@OneToMany
	@JoinColumn(name = "schnupperertag_id")
	private Set<Schnupperer> participants;

	@ManyToOne
	@JoinColumn(name = "berufsbildner_id")
	@NotNull
	private Berufsbildner director;

	@ManyToOne
	@JoinColumn(name = "fachrichtung_id")
	@NotNull
	private Fachrichtung fachrichtung;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Ort getOrt() {
		return ort;
	}

	public void setOrt(Ort ort) {
		this.ort = ort;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public Set<Schnupperer> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Schnupperer> participants) {
		this.participants = participants;
	}
	
	public void addParticipant(Schnupperer schnupperer) {
		this.participants.add(schnupperer);
	}

	public Berufsbildner getDirector() {
		return director;
	}

	public void setDirector(Berufsbildner director) {
		this.director = director;
	}

	public Fachrichtung getFachrichtung() {
		return fachrichtung;
	}

	public void setFachrichtung(Fachrichtung fachrichtung) {
		this.fachrichtung = fachrichtung;
	}

}
