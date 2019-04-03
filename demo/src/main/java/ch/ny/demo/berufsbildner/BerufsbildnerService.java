package ch.ny.demo.berufsbildner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ch.ny.demo.person.PersonRepository;
import ch.ny.demo.person.PersonService;

//business logic

@Service
public class BerufsbildnerService extends PersonService implements BerufsbildnerServiceable {

	private BerufsbildnerRepository repository;
	
	//automatisch die Objekte die man braucht instanzieren -> sorgt für dependency injection
	@Autowired
	public BerufsbildnerService(PersonRepository personRepo, BCryptPasswordEncoder bCryptPasswordEncoder, BerufsbildnerRepository repository) {
		super(personRepo, bCryptPasswordEncoder);
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
