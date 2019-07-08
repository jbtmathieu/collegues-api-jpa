package dev.Service;

import java.util.Optional;

import dev.entity.Collegue;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CollegueRepository extends JpaRepository<Collegue, String>{

    Optional<Collegue> findByNom(String lastname);

}
