package ch.ny.demo.berufsbildner;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ch.ny.demo.person.PersonServiceable;

@Service
@Primary
public interface BerufsbildnerServiceable extends PersonServiceable {

	public Optional<Berufsbildner> getById(Long id);
	
	public List<Berufsbildner> getAll();
	
	public void createBerufsbildner(Berufsbildner berufsbildner);
	
}
