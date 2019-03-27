package ch.ny.berufsbildner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//business logique

@Service
public class BerufsbildnerService implements BerufsbildnerServiceable {

	private BerufsbildnerRepository repository;
	
	//automatisch die Objekte die man braucht instanzieren -> sorgt für dependency injection
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
