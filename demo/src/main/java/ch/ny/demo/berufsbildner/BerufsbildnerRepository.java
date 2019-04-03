package ch.ny.demo.berufsbildner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.ny.demo.schnupperer.Schnupperer;

//@JpaRepository data access object

@Repository
public interface BerufsbildnerRepository extends JpaRepository<Berufsbildner, Long> {
	
	Berufsbildner findByUsername(String username);
	
	void deleteByUsername(String username);
	
}
