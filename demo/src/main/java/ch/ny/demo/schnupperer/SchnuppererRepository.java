package ch.ny.demo.schnupperer;

import org.springframework.stereotype.Repository;

import ch.ny.demo.person.PersonRepository;

@Repository
public interface SchnuppererRepository extends PersonRepository {

//	Schnupperer findByUsername(String username);
//	
//	void deleteByUsername(String username);
	
}
