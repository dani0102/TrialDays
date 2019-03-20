package ch.ny.schnuppertag;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchnuppertagService implements SchnuppertagServiceable {

	private SchnuppertagRepository repository;
	
	@Autowired
	public SchnuppertagService(SchnuppertagRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<Schnuppertag> getById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public List<Schnuppertag> getAll() {
		return repository.findAll();
	}

	@Override
	public void createSchnuppertag(Schnuppertag berufsbildner) {
		repository.save(berufsbildner);
	}

}