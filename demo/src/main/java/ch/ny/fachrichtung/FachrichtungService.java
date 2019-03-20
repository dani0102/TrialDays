package ch.ny.fachrichtung;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FachrichtungService implements FachrichtungServiceable {

	private FachrichtungRepository repository;
	
	@Autowired
	public FachrichtungService(FachrichtungRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<Fachrichtung> getById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public List<Fachrichtung> getAll() {
		return repository.findAll();
	}

	@Override
	public void createFachrichtung(Fachrichtung fachrichtung) {
		repository.save(fachrichtung);
	}
	
	
	
}
