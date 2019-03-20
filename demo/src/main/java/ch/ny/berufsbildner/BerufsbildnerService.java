package ch.ny.berufsbildner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BerufsbildnerService implements BerufsbildnerServiceable {

	private BerufsbildnerRepository repository;
	
	@Autowired
	public BerufsbildnerService(BerufsbildnerRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<Berufsbildner> getById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public List<Berufsbildner> getAll() {
		return repository.findAll();
	}

	@Override
	public void createBerufsbildner(Berufsbildner berufsbildner) {
		repository.save(berufsbildner);
	}

}
