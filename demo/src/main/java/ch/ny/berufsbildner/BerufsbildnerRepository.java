package ch.ny.berufsbildner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface BerufsbildnerRepository extends JpaRepository<Berufsbildner, Long> {
	
}
