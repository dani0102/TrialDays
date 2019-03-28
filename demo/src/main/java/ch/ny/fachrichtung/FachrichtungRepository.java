package ch.ny.fachrichtung;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FachrichtungRepository extends JpaRepository<Fachrichtung, Long> {

}
