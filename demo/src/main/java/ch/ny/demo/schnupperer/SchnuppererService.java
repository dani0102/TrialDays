package ch.ny.demo.schnupperer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ch.ny.demo.person.Person;
import ch.ny.demo.person.PersonRepository;
import ch.ny.demo.person.PersonService;

@Service
public class SchnuppererService extends PersonService implements SchnuppererServiceable{

	private SchnuppererRepository repository;
	
	@Autowired
	public SchnuppererService(PersonRepository personRepo, BCryptPasswordEncoder bCryptPasswordEncoder, SchnuppererRepository repository) {
		super(personRepo, bCryptPasswordEncoder);
		this.repository = repository;
	}
	
	@Override
	public Optional<Schnupperer> getById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public List<Schnupperer> getAll() {
		return repository.findAll();
	}

	@Override
	public void createSchnupperer(Schnupperer schnupperer) {
		// Create schnupperer's UUID
		schnupperer.setUuid(UUID.randomUUID());
		
		repository.save(schnupperer);
	}
	
}
