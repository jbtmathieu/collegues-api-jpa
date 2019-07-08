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


		collegueDataJpa.Lister().forEach(System.out::println);


	}
}
