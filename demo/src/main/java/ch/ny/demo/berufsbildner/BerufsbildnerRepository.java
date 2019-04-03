package ch.ny.demo.berufsbildner;

import org.springframework.stereotype.Repository;

import ch.ny.demo.person.PersonRepository;

//@JpaRepository data access object

@Repository
public interface BerufsbildnerRepository extends PersonRepository {
	
//	Berufsbildner findByUsername(String username);
//	
//	void deleteByUsername(String username);
	
}
