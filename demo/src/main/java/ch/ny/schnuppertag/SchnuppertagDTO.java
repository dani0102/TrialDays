package ch.ny.schnuppertag;

import java.sql.Date;
import java.util.Set;

import ch.ny.berufsbildner.Berufsbildner;
import ch.ny.fachrichtung.Fachrichtung;
import ch.ny.ort.Ort;
import ch.ny.schnupperer.Schnupperer;

public class SchnuppertagDTO {

	private Date date;
	
	private Ort ort;
	
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

	private int limit;
	
	private Set<Schnupperer> participants;
	
	private Berufsbildner director;
	
	private Fachrichtung fachrichtung;
	
}
