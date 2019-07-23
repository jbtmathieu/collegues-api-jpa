package dev;

import dev.Service.CollegueRepository;
import dev.Service.UtilisateurRepository;
import dev.entity.Collegue;
import dev.entity.Utilisateur;
import dev.jpa.CollegueDataJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;
    @CrossOrigin
    @Component
    public class StartupDataInit {

        @Autowired
        private CollegueRepository collegueRepository;
        @Autowired
        private UtilisateurRepository utilisateurRepository;
        @Autowired
        private PasswordEncoder passwordEncoder;
        

        public StartupDataInit(){

        }

        // La méthode init va être invoquée au démarrage de l'application.
        @EventListener(ContextRefreshedEvent.class)
        public void init() {
        	System.out.println("StartupDataInit Init");
            String ID;
            collegueRepository.save(new Collegue("30", "DUPONT", "Paul",
                    "dp@rty.com", LocalDate.now(), "http://site/img/dp"));
            utilisateurRepository.save(new Utilisateur(collegueRepository.findByMatricule("30").get().getEmail(),
            		passwordEncoder.encode(collegueRepository.findByMatricule("30").get().getEmail()), Arrays.asList("ROLE_USER")));
            
            collegueRepository.save(new Collegue("22", "DUPRE", "Raoul",
                    "dr@rty.com", LocalDate.now(), "http://site/img/dr"));
            utilisateurRepository.save(new Utilisateur(collegueRepository.findByMatricule("22").get().getEmail(),
            		passwordEncoder.encode(collegueRepository.findByMatricule("22").get().getEmail()), Arrays.asList("ROLE_USER")));
            
            collegueRepository.save(new Collegue("18", "BENOIT", "Arnaud",
                    "ab@cd.com", LocalDate.now(), "http://site/img/sy"));
            utilisateurRepository.save(new Utilisateur(collegueRepository.findByMatricule("18").get().getEmail(),
            		passwordEncoder.encode(collegueRepository.findByMatricule("18").get().getEmail()), Arrays.asList("ROLE_USER")));
            
            collegueRepository.save(new Collegue("10", "MARTIN", "Jean",
                    "mj@rty.com", LocalDate.now(), "https://randomuser.me/api/portraits/women/4.jpg"));
            utilisateurRepository.save(new Utilisateur(collegueRepository.findByMatricule("10").get().getEmail(),
            		passwordEncoder.encode(collegueRepository.findByMatricule("10").get().getEmail()), Arrays.asList("ROLE_USER")));
            
            
            
            ID=UUID.randomUUID().toString();
            collegueRepository.save(new Collegue(ID, "RAY", "Jean", "jean@greatcorp.com",
                    LocalDate.now().plusYears(-15).plusMonths(-4).plusDays(8), "http://my/great/path.png"));
            utilisateurRepository.save(new Utilisateur((collegueRepository.findByMatricule(ID).get().getEmail()),
            		passwordEncoder.encode(collegueRepository.findByMatricule(ID).get().getEmail()), Arrays.asList("ROLE_USER")));
            
            ID = UUID.randomUUID().toString();
            collegueRepository.save(new Collegue(ID, "SMITH", "Pierre", "pierre@greatcorp.com",
                    LocalDate.now().plusYears(-30).plusMonths(6).plusDays(12), "http://my/great/path.png"));
            utilisateurRepository.save(new Utilisateur((collegueRepository.findByMatricule(ID).get().getEmail()),
            		passwordEncoder.encode(collegueRepository.findByMatricule(ID).get().getEmail()), Arrays.asList("ROLE_USER")));
            

            ID = UUID.randomUUID().toString();
            collegueRepository.save(new Collegue(ID, "RAY", "John", "john@greatcorp.com",
                    LocalDate.now().plusYears(-17).plusMonths(9).plusDays(4), "http://my/great/path.png"));
            utilisateurRepository.save(new Utilisateur((collegueRepository.findByMatricule(ID).get().getEmail()),
            		passwordEncoder.encode(collegueRepository.findByMatricule(ID).get().getEmail()), Arrays.asList("ROLE_USER")));
            
            ID = UUID.randomUUID().toString();
            collegueRepository.save(new Collegue(ID, "MARTIN", "William", "will@greatcorp.com",
                    LocalDate.now(), "https://randomuser.me/api/portraits/men/1.jpg"));
            utilisateurRepository.save(new Utilisateur((collegueRepository.findByMatricule(ID).get().getEmail()),
            		passwordEncoder.encode(collegueRepository.findByMatricule(ID).get().getEmail()), Arrays.asList("ROLE_USER")));
            
            ID = UUID.randomUUID().toString();
            collegueRepository.save(new Collegue(ID, "MARTIN", "Yves", "my@greatcorp.com",
                    LocalDate.now().plusYears(-30).plusMonths(-3).plusDays(2), "https://randomuser.me/api/portraits/women/2.jpg"));
            utilisateurRepository.save(new Utilisateur((collegueRepository.findByMatricule(ID).get().getEmail()),
            		passwordEncoder.encode(collegueRepository.findByMatricule(ID).get().getEmail()), Arrays.asList("ROLE_USER")));
            
            ID = UUID.randomUUID().toString();
            collegueRepository.save(new Collegue(ID, "MARTIN", "John", "mj@greatcorp.com",
                    LocalDate.now().plusYears(-23).plusMonths(-4).plusDays(8), "https://randomuser.me/api/portraits/women/3.jpg"));
            utilisateurRepository.save(new Utilisateur((collegueRepository.findByMatricule(ID).get().getEmail()),
            		passwordEncoder.encode(collegueRepository.findByMatricule(ID).get().getEmail()), Arrays.asList("ROLE_USER")));

            ID = UUID.randomUUID().toString();
            collegueRepository.save(new Collegue(ID, "MARTIN", "Gilles", "mg@greatcorp.com",
                    LocalDate.now().plusYears(-25).plusMonths(-3).plusDays(10), "https://randomuser.me/api/portraits/women/4.jpg")); 
            utilisateurRepository.save(new Utilisateur((collegueRepository.findByMatricule(ID).get().getEmail()),
            		passwordEncoder.encode(collegueRepository.findByMatricule(ID).get().getEmail()), Arrays.asList("ROLE_USER")));
            
            ID = UUID.randomUUID().toString();
            collegueRepository.save(new Collegue(ID, "MARTIN", "Pierre", "mp@greatcorp.com",
                    LocalDate.now().plusYears(-18).plusMonths(6).plusDays(-6), "https://randomuser.me/api/portraits/women/5.jpg"));
            utilisateurRepository.save(new Utilisateur((collegueRepository.findByMatricule(ID).get().getEmail()),
            		passwordEncoder.encode(collegueRepository.findByMatricule(ID).get().getEmail()), Arrays.asList("ROLE_USER")));

            
            ID = UUID.randomUUID().toString();
            collegueRepository.save(new Collegue(ID, "MAHRT", "John", "jb@je.com",
                    LocalDate.now().plusYears(-20).plusMonths(5).plusDays(-3), "http://my/great/mj.png"));
            utilisateurRepository.save(new Utilisateur((collegueRepository.findByMatricule(ID).get().getEmail()),
            		passwordEncoder.encode(collegueRepository.findByMatricule(ID).get().getEmail()), Arrays.asList("ROLE_USER")));

            ID = UUID.randomUUID().toString();
            collegueRepository.save(new Collegue(ID, "MARTTY", "Jack", "mj@greatcorp.com",
                    LocalDate.now().plusYears(-16).plusMonths(3).plusDays(-4), "http://my/great/mj.png"));
            utilisateurRepository.save(new Utilisateur((collegueRepository.findByMatricule(ID).get().getEmail()),
            		passwordEncoder.encode(collegueRepository.findByMatricule(ID).get().getEmail()), Arrays.asList("ROLE_ADMIN","ROLE_USER")));
            

            
            
        }
    }

