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

    @Component
    public class StartupDataInit {

        @Autowired
        CollegueRepository collegueRepository;

        public StartupDataInit(){

        }

        // La méthode init va être invoquée au démarrage de l'application.
        @EventListener(ContextRefreshedEvent.class)
        public void init() {
            collegueRepository.save(new Collegue("30", "DUPONT", "Paul",
                    "dp@rty.com", LocalDate.now(), "http://site/img/dp"));
            collegueRepository.save(new Collegue("10", "MARTIN", "Jean",
                    "mj@rty.com", LocalDate.now(), "http://site/img/mj"));
            collegueRepository.save(new Collegue("22", "DUPRE", "Raoul",
                    "dr@rty.com", LocalDate.now(), "http://site/img/dr"));
            collegueRepository.save(new Collegue("18", "SAPIN", "Yves",
                    "sy@rty.com", LocalDate.now(), "http://site/img/sy"));
        }
    }

