package ch.ny.schnupperer;

import java.util.List;
import java.util.Optional;

public interface SchnuppererServiceable {
	
	public Optional<Schnupperer> getById(Long id);
	
	public List<Schnupperer> getAll();
	
	public void createSchnupperer(Schnupperer berufsbildner);
	
}
