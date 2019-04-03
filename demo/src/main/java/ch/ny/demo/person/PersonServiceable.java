package ch.ny.demo.person;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface PersonServiceable extends UserDetailsService {

	Person findByUsername(String name);
	
	void deleteByUsername(String name);
	
}
