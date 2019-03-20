package ch.ny.fachrichtung;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface FachrichtungServiceable {

	public Optional<Fachrichtung> getById(Long id);
	
	public List<Fachrichtung> getAll();
	
	public void createFachrichtung(Fachrichtung fachrichtung);
	
}
