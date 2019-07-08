package dev;

import dev.entity.Collegue;
import dev.jpa.CollegueDataJpa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;

//https://mathieu-collegues-api.herokuapp.com/collegues?name=SMITH

@SpringBootApplication
public class ColleguesApiApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(ColleguesApiApplication.class, args);

		CollegueDataJpa collegueDataJpa = context.getBean(CollegueDataJpa.class);

		Collegue collegue = new Collegue("30", "DUPONT", "Paul",
				"dp@rty.com", LocalDate.now(), "http://site/img/dp");
		collegueDataJpa.creer(collegue);
		collegueDataJpa.creer(new Collegue("10", "MARTIN", "Jean",
				"mj@rty.com", LocalDate.now(), "http://site/img/mj"));
		collegueDataJpa.creer(new Collegue("22", "DUPRE", "Raoul",
				"dr@rty.com", LocalDate.now(), "http://site/img/dr"));
		collegueDataJpa.creer(new Collegue("18", "SAPIN", "Yves",
				"sy@rty.com", LocalDate.now(), "http://site/img/sy"));
		collegueDataJpa.Lister().forEach(System.out::println);


	}
}
