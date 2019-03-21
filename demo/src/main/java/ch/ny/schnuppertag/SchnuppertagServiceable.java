package ch.ny.schnuppertag;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ch.ny.schnupperer.Schnupperer;

@Service
public interface SchnuppertagServiceable {

	public Optional<Schnuppertag> getById(Long id);
	
	public List<Schnuppertag> getAll();
	
	public void createSchnuppertag(Schnuppertag berufsbildner);
	
	public void addSchnupperer(long schnuppererId, long schnuppertagId);
	
}
