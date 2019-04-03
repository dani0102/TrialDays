package ch.ny.demo.schnupperer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.ny.demo.berufsbildner.Berufsbildner;

@Repository
public interface SchnuppererRepository extends JpaRepository<Schnupperer, Long> {

	Schnupperer findByUsername(String username);
	
	void deleteByUsername(String username);
	
}
