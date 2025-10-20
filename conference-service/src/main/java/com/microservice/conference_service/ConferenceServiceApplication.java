package com.microservice.conference_service;

import com.microservice.conference_service.entities.Conference;
import com.microservice.conference_service.entities.Review;
import com.microservice.conference_service.enums.ConferenceType;
import com.microservice.conference_service.feign.KeynoteRestClient;
import com.microservice.conference_service.mapper.ConferenceMapper;
import com.microservice.conference_service.mapper.ReviewMapper;
import com.microservice.conference_service.models.Keynote;
import com.microservice.conference_service.repo.ConferenceRepo;
import com.microservice.conference_service.repo.ReviewRepo;
import org.apache.catalina.LifecycleState;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class ConferenceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConferenceServiceApplication.class, args);
	}

    @Bean
    CommandLineRunner initData(
            ConferenceRepo conferenceRepo,
            ReviewRepo reviewRepo,
            KeynoteRestClient keynoteRestClient
    ) {
        return args -> {

            Collection<Keynote> keynotes = keynoteRestClient.findAllKeynote().getContent();

            keynotes.forEach(item->{
                System.out.println(item.getId() + " : " + item.getEmail());
            });
            // Initialize sample conferences
            Conference conference1 = Conference.builder()
                    .title("Tech Summit 2025")
                    .type(Math.random() > 0.5? ConferenceType.ACADEMIQUE_TYPE : ConferenceType.COMMERCIAL_TYPE)
                    .date(new Date())
                    .duration(120L)
                    .inscription(100L)
                    .score(4.5)
                    .keynoteId("n")
                    .build();

            Conference conference2 = Conference.builder()
                    .title("AI Revolution")
                    .type(Math.random() > 0.5? ConferenceType.ACADEMIQUE_TYPE : ConferenceType.COMMERCIAL_TYPE)
                    .date(new Date())
                    .duration(90L)
                    .inscription(150L)
                    .score(4.8)
                    .keynoteId("b")
                    .build();

            conferenceRepo.save(conference1);
            conferenceRepo.save(conference2);


//            for(int i = 0; i<10 ;i++){
//                Review review2 = Review.builder()
//                        .createdAt(new Date())
//                        .text("Great conference with insightful talks!")
//                        .note(Math.random()*5)
//                        .conference(conference1)
//                        .build();
//
//                reviewRepo.save(review2);
//            }
//
//
//
//            for(int i = 0; i<10 ;i++){
//                Review review1 = Review.builder()
//                        .createdAt(new Date())
//                        .text("Great conference with insightful talks!")
//                        .note(Math.random()*5)
//                        .conference(conference1)
//                        .build();
//
//                reviewRepo.save(review1);
//            }

            System.out.println("Initialized sample conference data");
        };
    }
}
