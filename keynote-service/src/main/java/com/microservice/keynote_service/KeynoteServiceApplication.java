package com.microservice.keynote_service;

import com.microservice.keynote_service.entities.Keynote;
import com.microservice.keynote_service.repo.KeynoteRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

class Person {
    public String firstName;
    public String lastName;
    public String func;

    // Constructor
    public Person(String firstName, String lastName,String func) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.func = func;
    }
}
@SpringBootApplication
public class KeynoteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeynoteServiceApplication.class, args);
	}

    @Bean
    CommandLineRunner commandLineRunner(
            KeynoteRepo keynoteRepo
    ){
        return args -> {
            Person[] people = {
                    new Person("John", "Doe","func1"),
                    new Person("Jane", "Smith","func2"),
                    new Person("Alice", "Johnson","func1")
            };

            // Create a stream from the array and process with forEach
            Stream.of(people).forEach(item -> {
                Keynote keynote = Keynote.builder()
                        .nom(item.lastName)
                        .prenom(item.firstName)
                        .email(item.firstName+"_"+item.lastName+"@gmail.com")
                        .function(item.func)
                        .build();
                keynoteRepo.save(keynote);
            });
        };
    }
}
