package dev;

import dev.Service.CollegueRepository;
import dev.entity.Collegue;
import dev.jpa.CollegueDataJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

    @Component
    public class StartupDataInit {

        @Autowired
        CollegueRepository collegueRepository;

        public StartupDataInit(){

        }

        // La méthode init va être invoquée au démarrage de l'application.
        @EventListener(ContextRefreshedEvent.class)
        public void init() {
            String ID;
            collegueRepository.save(new Collegue("30", "DUPONT", "Paul",
                    "dp@rty.com", LocalDate.now(), "http://site/img/dp"));
            collegueRepository.save(new Collegue("10", "MARTIN", "Jean",
                    "mj@rty.com", LocalDate.now(), "https://publicdomainvectors.org/en/free-clipart/Cute-cartoon-cat-portrait-vector-drawing/15546.html"));
            collegueRepository.save(new Collegue("22", "DUPRE", "Raoul",
                    "dr@rty.com", LocalDate.now(), "http://site/img/dr"));
            collegueRepository.save(new Collegue("18", "SAPIN", "Yves",
                    "sy@rty.com", LocalDate.now(), "http://site/img/sy"));
            

            collegueRepository.save(new Collegue(UUID.randomUUID().toString(), "RAY", "Jean", "jean@greatcorp.com",
                    LocalDate.now().plusYears(-15).plusMonths(-4).plusDays(8), "http://my/great/path.png"));
            

            collegueRepository.save(new Collegue("123", "RAY", "Jacques", "jacques@greatcorp.com",
                    LocalDate.now().plusYears(-12).plusMonths(-3).plusDays(2), "http://my/great/path.png"));

            ID = UUID.randomUUID().toString();
            collegueRepository.save(new Collegue(ID, "SMITH", "Pierre", "pierre@greatcorp.com",
                    LocalDate.now().plusYears(-30).plusMonths(6).plusDays(12), "http://my/great/path.png"));
            

            ID = UUID.randomUUID().toString();
            collegueRepository.save(new Collegue(ID, "RAY", "John", "john@greatcorp.com",
                    LocalDate.now().plusYears(-17).plusMonths(9).plusDays(4), "http://my/great/path.png"));
            

            ID = UUID.randomUUID().toString();
            collegueRepository.save(new Collegue(ID, "MARTIN", "William", "will@greatcorp.com",
                    LocalDate.now(), "https://www.shutterstock.com/fr/image-vector/happy-cartoon-puppy-sitting-portrait-cute-582282628"));
            

            collegueRepository.save(new Collegue(ID, "MARTIN", "Yves", "my@greatcorp.com",
                    LocalDate.now().plusYears(-30).plusMonths(-3).plusDays(2), "https://www.shutterstock.com/fr/image-illustration/raccoon-isolated-on-white-background-watercolor-1184033932"));

            ID = UUID.randomUUID().toString();

            collegueRepository.save(new Collegue(ID, "MAHRT", "John", "mj@greatcorp.com",
                    LocalDate.now().plusYears(-20).plusMonths(5).plusDays(-3), "http://my/great/mj.png"));

            ID = UUID.randomUUID().toString();

            collegueRepository.save(new Collegue(ID, "MARTTY", "Jack", "mj@greatcorp.com",
                    LocalDate.now().plusYears(-16).plusMonths(3).plusDays(-4), "http://my/great/mj.png"));

            ID = UUID.randomUUID().toString();

            collegueRepository.save(new Collegue(ID, "MARTIN", "Pierre", "mp@greatcorp.com",
                    LocalDate.now().plusYears(-18).plusMonths(6).plusDays(-6), "https://www.shutterstock.com/fr/image-vector/pembroke-welsh-corgi-lap-dog-breed-1139306972"));

            ID = UUID.randomUUID().toString();

            collegueRepository.save(new Collegue(ID, "MARTIN", "John", "mj@greatcorp.com",
                    LocalDate.now().plusYears(-23).plusMonths(-4).plusDays(8), "https://www.shutterstock.com/fr/image-vector/cartoon-black-cat-drawing-simple-cute-1160993116"));

            ID = UUID.randomUUID().toString();

            collegueRepository.save(new Collegue(ID, "MARIN", "Gilles", "mg@greatcorp.com",
                    LocalDate.now().plusYears(-25).plusMonths(-3).plusDays(10), "http://my/great/mg.png")); 

            
            
        }
    }

