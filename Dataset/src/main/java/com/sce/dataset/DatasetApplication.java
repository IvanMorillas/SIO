package com.sce.dataset;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;


@SpringBootApplication
public class DatasetApplication {

	private static final Logger log = LoggerFactory.getLogger(DatasetApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DatasetApplication.class);
	}

	@Bean
	public CommandLineRunner demoPerson(IPerson repository) {
		return (args) -> {
			repository.save(new Person(59401, "ts20945", "Joe Besser", "Joe", "ACTOR"));
			log.info("Persons found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(Person -> {
				log.info(Person.toString());
			});
			log.info("");
		};
	}

	@Bean
	public CommandLineRunner demoTitle(ITitle repository) {
		return (args) -> {
			repository.save(new Title("ts20945","The Three Stooges","SHOW",
					"The Three Stooges were an American vaudeville .",1934,
					"TV-PG",19, Arrays.asList("comedy", "family", "animation", "action", "fantasy", "horror"),
					Arrays.asList("US","ESP"),26.0,"tt0850645",8.6,
					1092.0,15.424,7.6));
			log.info("Titles found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(Title -> {
				log.info(Title.toString());
			});
			log.info("");
		};
	}

	/*@Bean
	public CommandLineRunner demoCustomer(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");
		};
	}*/







	/*public static void main(String[] args) {
		SpringApplication.run(DatasetApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(DAO dao){
		return runner -> {
			addPerson(dao);
		};
	}
	private @Transactional void addPerson(DAO dao){
		Person tempPerson = new Person(59401,tempTitle,"Joe Besser","Joe","ACTOR");

		Title tempTitle = new Title("ts20945","The Three Stooges","SHOW",
				"The Three Stooges were an American vaudeville.",1934,"TV-PG",19,
				Arrays.asList("comedy", "family", "animation", "action", "fantasy", "horror"),Arrays.asList("US", "ESP"),
				26.0,"tt0850645",8.6,1092.0,15.424,7.6);


		tempPerson.setTitle(tempTitle);
		//System.out.println("Title added.\n");


		//dao.savePerson(tempPerson);
		System.out.println("Person added.\n");

		//dao.saveTitle(tempTitle);
	}*/
}
