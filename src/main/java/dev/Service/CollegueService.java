package dev.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import dev.entity.Collegue;
import dev.exception.CollegueInvalidException;
import dev.exception.CollegueNontrouveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CollegueService {

    private static final int AGE_MIN = 18;
    private Map<String, Collegue> data = new HashMap<>();

    @Autowired
    private CollegueRepository collegueRepository;

    public CollegueService() {
/*
        Collegue coll;
        String ID;
        ID = UUID.randomUUID().toString();
        coll = new Collegue(ID, "RAY", "Jean", "jean@greatcorp.com",
                LocalDate.now().plusYears(-15).plusMonths(-4).plusDays(8), "http://my/great/path.png");
        data.put(ID, coll);

        coll = new Collegue("123", "RAY", "Jacques", "jacques@greatcorp.com",
                LocalDate.now().plusYears(-12).plusMonths(-3).plusDays(2), "http://my/great/path.png");
        data.put("123", coll);

        ID = UUID.randomUUID().toString();
        coll = new Collegue(ID, "SMITH", "Pierre", "pierre@greatcorp.com",
                LocalDate.now().plusYears(-30).plusMonths(6).plusDays(12), "http://my/great/path.png");
        data.put(ID, coll);

        ID = UUID.randomUUID().toString();
        coll = new Collegue(ID, "RAY", "John", "john@greatcorp.com",
                LocalDate.now().plusYears(-17).plusMonths(9).plusDays(4), "http://my/great/path.png");
        data.put(ID, coll);

        ID = UUID.randomUUID().toString();
        coll = new Collegue(ID, "MARTIN", "William", "will@greatcorp.com",
                LocalDate.now(), "http://my/great/path.png");
        data.put(ID, coll);

        ID = UUID.randomUUID().toString(); // pour générer un nouvel ID

        data.put(UUID.randomUUID().toString(), new Collegue(ID, "MARTIN", "Yves", "my@greatcorp.com",
                LocalDate.now().plusYears(-30).plusMonths(-3).plusDays(2), "http://my/great/my.png"));

        ID = UUID.randomUUID().toString();

        data.put(UUID.randomUUID().toString(), new Collegue(ID, "MAHRT", "John", "mj@greatcorp.com",
                LocalDate.now().plusYears(-20).plusMonths(5).plusDays(-3), "http://my/great/mj.png"));

        ID = UUID.randomUUID().toString();

        data.put(UUID.randomUUID().toString(), new Collegue(ID, "MARTTY", "Jack", "mj@greatcorp.com",
                LocalDate.now().plusYears(-16).plusMonths(3).plusDays(-4), "http://my/great/mj.png"));

        ID = UUID.randomUUID().toString();

        data.put(UUID.randomUUID().toString(), new Collegue(ID, "MARTIN", "Pierre", "mp@greatcorp.com",
                LocalDate.now().plusYears(-18).plusMonths(6).plusDays(-6), "http://my/great/mp.png"));

        ID = UUID.randomUUID().toString();

        data.put(UUID.randomUUID().toString(), new Collegue(ID, "MARSOUIN", "John", "mj@greatcorp.com",
                LocalDate.now().plusYears(-23).plusMonths(-4).plusDays(8), "http://my/greatmj.png"));

        ID = UUID.randomUUID().toString();

        data.put(UUID.randomUUID().toString(), new Collegue(ID, "MARIN", "Gilles", "mg@greatcorp.com",
                LocalDate.now().plusYears(-25).plusMonths(-3).plusDays(10), "http://my/great/mg.png"));
*/
    }

    public List<Collegue> rechercherParNom(String nomRecherche) {

        return collegueRepository.findByNom(nomRecherche);

    }

    public Collegue rechercherParMatricule(String matriculeRecherche) {
        
        
        return collegueRepository.findByMatricule(matriculeRecherche).orElseThrow(() -> new CollegueNontrouveException("Matricule non trouvé"));

    }

    public Collegue ajouterUnCollegue(Collegue collegueAAjouter) {

        if (collegueAAjouter != null) {
            // TODO Vérifier que le nom et les prenoms ont chacun au moins 2 caractères
            if (collegueAAjouter.getNom().length() > 2 &&
                    collegueAAjouter.getPrenoms().length() > 2) {
                // TODO Vérifier que l'email a au moins 3 caractères et contient `@`
                if (collegueAAjouter.getEmail().length() >= 3 &&
                        collegueAAjouter.getEmail().contains("@")) {
                    // TODO Vérifier que la photoUrl commence bien par `http`
                    if (collegueAAjouter.getPhotoUrl().startsWith("http")) {
                        // TODO Vérifier que la date de naissance correspond à un age >= 18
                        if (Period.between(collegueAAjouter.getDdn(), LocalDate.now()).getYears() >= AGE_MIN) {

                            // TODO générer un matricule pour ce collègue (`UUID.randomUUID().toString()`)
                            collegueAAjouter.setMatricule(UUID.randomUUID().toString());
                            // TODO Sauvegarder le collègue
                            data.put(collegueAAjouter.getMatricule(), collegueAAjouter);
                            // System.out.println(data.size());

                            return collegueAAjouter;

                        } else
                            throw new CollegueInvalidException("Not Legal Aged.");
                    } else
                        throw new CollegueInvalidException("PhotoPath Invalid.");
                } else
                    throw new CollegueInvalidException("Email Invalid.");
            } else
                throw new CollegueInvalidException("Name and FirstName too short.");
        } else
            throw new CollegueInvalidException("No Data");

        // TODO Si une des règles ci-dessus n'est pas valide, générer une exception :
        // `CollegueInvalideException`.
    }

    public Collegue modifierEmail(String matricule, String email) {

        Collegue collegue = rechercherParMatricule(matricule);

        // TODO retourner une exception `CollegueNonTrouveException`
        // si le matricule ne correspond à aucun collègue

        if (email.length() >= 3 && email.contains("@")) {

            // TODO Modifier le collègue
            collegue.setEmail(email);
            collegueRepository.save(collegue);

            return collegue;

        } else
            throw new CollegueInvalidException("Email Invalid.");
    }

    public Collegue modifierPhotoUrl(String matricule, String photoUrl) {

        Collegue collegue = rechercherParMatricule(matricule);
        // TODO retourner une exception `CollegueNonTrouveException`
        // si le matricule ne correspond à aucun collègue

        if (photoUrl.startsWith("http")) {

            // TODO Modifier le collègue
            collegue.setPhotoUrl(photoUrl);
            
            collegueRepository.save(collegue);

            return collegue;

        } else
            throw new CollegueInvalidException("PhotoPath Invalid.");
        
    }

}
