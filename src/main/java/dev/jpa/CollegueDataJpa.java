package dev.jpa;

import dev.entity.Collegue;
import dev.Service.CollegueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@Repository
public class CollegueDataJpa {


    @Autowired
    private CollegueRepository collegueRepository;


    public List<Collegue> Lister(){


        return collegueRepository.findAll();
    }

    //@Transactional(propagation=Propagation.REQUIRED)
    public void creer(Collegue coll) {

        collegueRepository.save(coll);
    }

    public List<Collegue> RechercherByNom(String name){

        return collegueRepository.findByNom(name);
    }
}
