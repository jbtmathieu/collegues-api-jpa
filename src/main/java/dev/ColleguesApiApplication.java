package dev;

import dev.Service.CollegueRepository;
import dev.Service.UtilisateurRepository;
import dev.entity.Collegue;
import dev.entity.Utilisateur;
import dev.jpa.CollegueDataJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Arrays;

//https://mathieu-collegues-api.herokuapp.com/collegues?name=SMITH

@SpringBootApplication
public class ColleguesApiApplication {
	
	
	@Autowired
    private CollegueRepository collegueRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
	@EventListener(ContextRefreshedEvent.class)
	public void init() {
		System.out.println("Collegues Api App Init");
		collegueRepository.save(new Collegue("123", "Blue", "John", "jb@jb.com",
                LocalDate.now().plusYears(-12).plusMonths(-3).plusDays(2), "http://my/great/path.png"));
        utilisateurRepository.save(new Utilisateur(collegueRepository.findByMatricule("123").get().getEmail(),
        		passwordEncoder.encode(collegueRepository.findByMatricule("123").get().getEmail()), Arrays.asList("ROLE_ADMIN","ROLE_USER")));
        
		
	}
	
	
	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(ColleguesApiApplication.class, args);


		CollegueDataJpa collegueDataJpa = context.getBean(CollegueDataJpa.class);


		collegueDataJpa.Lister().forEach(System.out::println);


	}
}
