package ch.ny.demo.schnupperer;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface SchnuppererServiceable {
	
	public Optional<Schnupperer> getById(Long id);
	
	public List<Schnupperer> getAll();
	
	public void createSchnupperer(Schnupperer berufsbildner);
	
}
