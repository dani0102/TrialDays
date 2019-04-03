package ch.ny.demo.role;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface RoleServiceable {

	public Optional<Role> getById(Long id);
	
	public List<Role> getAll();
	
	public void createFachrichtung(Role role);
	
}
