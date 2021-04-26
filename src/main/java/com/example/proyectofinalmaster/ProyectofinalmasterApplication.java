package com.example.proyectofinalmaster;

import com.example.proyectofinalmaster.model.Skilled;
import com.example.proyectofinalmaster.model.Tags;
import com.example.proyectofinalmaster.repository.SkilledRepository;
import com.example.proyectofinalmaster.service.SkilledService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProyectofinalmasterApplication implements CommandLineRunner {

	private final SkilledService skilledService;
	private final SkilledRepository skilledRepository;

	public ProyectofinalmasterApplication(SkilledService skilledService, SkilledRepository skilledRepository) {
		this.skilledService = skilledService;
		this.skilledRepository = skilledRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProyectofinalmasterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Skilled skilled = new Skilled ("Juan Diaz",LocalDate.now(), LocalDate.now(),
				"null" , "Mañanas", "Frontend", true,
				"22366512", "ju1@email.com", "España",
				"ju1@linkedln.com", "10.00", "15.00", "55",
				"98837212Y", "admin", "null", "admin",
				"123", "null", "null", "null","null",
				"Validado");

		Skilled skilled2 = new Skilled("Anabel López",LocalDate.now(), LocalDate.now(),
				"null" , "Tardes", "Frontend", false,
				"98735688", "bel1@email.com", "Mexico",
				"bel1@linkedln.com", "20.00", "35.00", "100",
				"09932783R", "admin", "null", "admin",
				"345", "null", "null", "null","null",
				"Validado");

		Skilled skilled3 = new Skilled("William Smith",LocalDate.now(), LocalDate.now(),
				"null" , "Tardes", "Backend", false,
				"34478655", "will1@email.com", "Estados Unidos",
				"will1@linkedln.com", "10.00", "25.00", "25",
				"88231456U", "admin", "null", "admin",
				"678", "null", "null", "null","null",
				"Pdte.Validar");

		Skilled skilled4 = new Skilled("Alvaro Martinez",LocalDate.now(), LocalDate.now(),
				"null" , "Mañanas", "Frontend", true,
				"38336672", "al1@email.com", "España",
				"al1@linkedln.com", "25.00", "40.00", "100",
				"77328569W", "admin", "null", "admin",
				"912", "null", "null", "null","null",
				"Validado");

		Skilled skilled5 = new Skilled("Hanz Müller",LocalDate.now(), LocalDate.now(),
				"null" , "Mañanas", "Frontend", false,
				"87235568", "ha1@email.com", "Alemania",
				"ha1@linkedln.com", "10.00", "35.00", "75",
				"79346612P", "admin", "null", "admin",
				"234", "null", "null", "null","null",
				"Pdte.Validar");

		Tags tag = new Tags ("Angular", LocalDate.now(), LocalDate.now());
		Tags tag2 = new Tags ("React", LocalDate.now(), LocalDate.now());
		Tags tag3 = new Tags ("Javascript", LocalDate.now(), LocalDate.now());
		Tags tag4 = new Tags ("Java", LocalDate.now(), LocalDate.now());
		Tags tag5 = new Tags ("C#", LocalDate.now(), LocalDate.now());
		Tags tag6 = new Tags ("C ++", LocalDate.now(), LocalDate.now());
		Tags tag7 = new Tags ("MySql", LocalDate.now(), LocalDate.now());
		Tags tag8 = new Tags ("CSS", LocalDate.now(), LocalDate.now());
		Tags tag9 = new Tags ("Python", LocalDate.now(), LocalDate.now());
		Tags tag10 = new Tags ("HTML", LocalDate.now(), LocalDate.now());


		tag.getSkilleds().add(skilled);
		tag2.getSkilleds().add(skilled);
		tag3.getSkilleds().add(skilled2);
		tag4.getSkilleds().add(skilled3);
		tag5.getSkilleds().add(skilled3);
		tag6.getSkilleds().add(skilled3);
		tag7.getSkilleds().add(skilled4);
		tag8.getSkilleds().add(skilled4);
		tag9.getSkilleds().add(skilled5);
		tag10.getSkilleds().add(skilled5);

		skilled.getTags().add(tag);
		skilled.getTags().add(tag2);
		skilled2.getTags().add(tag3);
		skilled3.getTags().add(tag4);
		skilled3.getTags().add(tag5);
		skilled3.getTags().add(tag6);
		skilled4.getTags().add(tag7);
		skilled4.getTags().add(tag8);
		skilled5.getTags().add(tag9);
		skilled5.getTags().add(tag10);


		skilledRepository.save(skilled);
		skilledRepository.save(skilled2);
		skilledRepository.save(skilled3);
		skilledRepository.save(skilled4);
		skilledRepository.save(skilled5);
	}
}
