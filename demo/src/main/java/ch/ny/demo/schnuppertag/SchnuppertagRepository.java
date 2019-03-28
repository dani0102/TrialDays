package ch.ny.demo.schnuppertag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchnuppertagRepository extends JpaRepository<Schnuppertag, Long>{

}
