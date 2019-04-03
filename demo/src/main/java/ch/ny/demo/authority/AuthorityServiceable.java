package ch.ny.demo.authority;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface AuthorityServiceable {

	public Optional<Authority> getById(Long id);
	
	public List<Authority> getAll();
	
	public void createFachrichtung(Authority authority);
	
}
