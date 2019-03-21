package ch.ny.schnuppertag;

import java.sql.Date;
import java.util.Set;
import java.util.UUID;

import ch.ny.berufsbildner.BerufsbildnerDTO;
import ch.ny.fachrichtung.FachrichtungDTO;
import ch.ny.ort.OrtDTO;
import ch.ny.schnupperer.SchnuppererDTO;

public class SchnuppertagDTO {

	private Date date;
	
	private UUID uid;
	
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

	public UUID getUid() {
		return uid;
	}

	public void setUid(UUID uid) {
		this.uid = uid;
	}
}
