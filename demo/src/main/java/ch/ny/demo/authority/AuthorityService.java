package ch.ny.demo.authority;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService implements AuthorityServiceable{

	private AuthorityRepository repository;
	
	@Autowired
	public AuthorityService(AuthorityRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<Authority> getById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Authority> getAll() {
		return repository.findAll();
	}

	@Override
	public void createFachrichtung(Authority authority) {
		repository.save(authority);
	}

}
