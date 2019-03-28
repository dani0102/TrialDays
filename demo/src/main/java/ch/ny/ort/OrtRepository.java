package ch.ny.ort;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrtRepository extends JpaRepository<Ort, Long> {

}
