package ch.ny.demo.schnupperer;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import ch.ny.demo.person.PersonServiceable;

@Service
public interface SchnuppererServiceable extends PersonServiceable{
	
	public Optional<Schnupperer> getById(Long id);
	
	public List<Schnupperer> getAll();
	
	public void createSchnupperer(Schnupperer berufsbildner);
	
}
