package dev.Service;

import java.util.List;
import java.util.Optional;

import dev.entity.Collegue;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CollegueRepository extends JpaRepository<Collegue, Integer>{

    List<Collegue> findByNom(String lastname);

    Optional<Collegue> findByMatricule(String matriculeRecherche);

}
