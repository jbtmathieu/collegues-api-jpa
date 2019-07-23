package dev.Service;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{
	
	Optional<Utilisateur> findByNomUtilisateur(String nomUtilisateur);
}
