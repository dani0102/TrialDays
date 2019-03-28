package ch.ny.demo.berufsbildner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@JpaRepository data access object

@Repository
public interface BerufsbildnerRepository extends JpaRepository<Berufsbildner, Long> {
	
}
