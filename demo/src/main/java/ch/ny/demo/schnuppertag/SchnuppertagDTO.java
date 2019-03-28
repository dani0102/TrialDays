package ch.ny.demo.schnuppertag;

import java.sql.Date;
import java.util.Set;

import ch.ny.demo.berufsbildner.BerufsbildnerDTO;
import ch.ny.demo.fachrichtung.FachrichtungDTO;
import ch.ny.demo.ort.OrtDTO;
import ch.ny.demo.schnupperer.SchnuppererDTO;

public class SchnuppertagDTO {

	private Date date;
	
	private OrtDTO ort;

	private int limit;
	
	private Set<SchnuppererDTO> participants;
	
	private BerufsbildnerDTO director;
	
	private FachrichtungDTO fachrichtung;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public OrtDTO getOrt() {
		return ort;
	}

	public void setOrt(OrtDTO ort) {
		this.ort = ort;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public Set<SchnuppererDTO> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<SchnuppererDTO> participants) {
		this.participants = participants;
	}

	public BerufsbildnerDTO getDirector() {
		return director;
	}

	public void setDirector(BerufsbildnerDTO director) {
		this.director = director;
	}

	public FachrichtungDTO getFachrichtung() {
		return fachrichtung;
	}

	public void setFachrichtung(FachrichtungDTO fachrichtung) {
		this.fachrichtung = fachrichtung;
	}
}
