package ch.ny.demo.ort;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface OrtServiceable {

	public Optional<Ort> getById(Long id);
	
	public List<Ort> getAll();
	
	public void createOrt(Ort ort);
	
}
