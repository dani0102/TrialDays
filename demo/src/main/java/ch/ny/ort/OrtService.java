package ch.ny.ort;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrtService implements OrtServiceable {

	private OrtRepository repository;
	
	@Autowired
	public OrtService(OrtRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<Ort> getById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public List<Ort> getAll() {
		return repository.findAll();
	}

	@Override
	public void createOrt(Ort ort) {
		repository.save(ort);
	}

}
