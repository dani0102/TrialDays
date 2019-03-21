package ch.ny.schnupperer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchnuppererService implements SchnuppererServiceable{

	private SchnuppererRepository repository;
	
	@Autowired
	public SchnuppererService(SchnuppererRepository repository) {
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
		repository.save(schnupperer);
	}
	
}
