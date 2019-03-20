package ch.ny.berufsbildner;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface BerufsbildnerServiceable {

	public Optional<Berufsbildner> getById(Long id);
	
	public List<Berufsbildner> getAll();
	
	public void createBerufsbildner(Berufsbildner berufsbildner);
	
}
