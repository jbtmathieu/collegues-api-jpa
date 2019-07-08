package dev;

import dev.Service.CollegueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

public class StartupDataUnit {
    @Component
    public class StartupDataInit {

        @Autowired
        CollegueRepository collegueRepo;


        // La méthode init va être invoquée au démarrage de l'application.
        @EventListener(ContextRefreshedEvent.class)
        public void init() {

            // TODO insérer des collègues en base de données

        }
    }
}
