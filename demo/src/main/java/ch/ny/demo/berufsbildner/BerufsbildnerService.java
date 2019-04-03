package ch.ny.demo.berufsbildner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ch.ny.demo.person.PersonService;

//business logic

@Service
public class BerufsbildnerService extends PersonService implements BerufsbildnerServiceable {

	private BerufsbildnerRepository repository;
	
	//automatisch die Objekte die man braucht instanzieren -> sorgt f�r dependency injection
	@Autowired
	public BerufsbildnerService(BCryptPasswordEncoder bCryptPasswordEncoder, BerufsbildnerRepository repository) {
		super(repository, bCryptPasswordEncoder);
		this.repository = repository;
	}
	
	@Override
	public Optional<Berufsbildner> getById(Long id) {
		var result = (Berufsbildner)this.repository.findById(id).get();
		return Optional.of(result);
	}

	@Override
	public List<Berufsbildner> getAll() {
		var result = (Berufsbildner)this.repository.findAll();
		return List.of(result);
	}

	@Override
	public void createBerufsbildner(Berufsbildner berufsbildner) {
		repository.save(berufsbildner);
	}

}
