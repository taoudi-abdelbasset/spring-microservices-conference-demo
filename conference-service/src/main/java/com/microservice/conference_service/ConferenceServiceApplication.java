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

import java.util.*;

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

            List<Keynote> keynotes = keynoteRestClient.findAllKeynote();

            keynotes.forEach(item->{
                // Initialize sample conferences
                Conference conference = Conference.builder()
                        .title("Tech Summit 2025")
                        .type(Math.random() > 0.5? ConferenceType.ACADEMIQUE_TYPE : ConferenceType.COMMERCIAL_TYPE)
                        .date(new Date())
                        .duration(20L + new Random().nextInt(100))
                        .inscription(10L + new Random().nextInt(40))
                        .score(4.5)
                        .keynoteId(item.getId())
                        .keynote(item)
                        .build();

                conferenceRepo.save(conference);
                for(int i = 0; i<10 ;i++) {
                    Review review = Review.builder()
                            .createdAt(new Date())
                            .text("Great conference with insightful talks!")
                            .note(Math.random() * 5)
                            .conference(conference)
                            .build();

                    reviewRepo.save(review);
                }
            });

            System.out.println("Initialized sample conference data");
        };
    }
}
