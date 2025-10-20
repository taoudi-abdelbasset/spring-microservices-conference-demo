package com.microservice.conference_service.mapper;

import com.microservice.conference_service.dtos.ConferenceDTO;
import com.microservice.conference_service.entities.Conference;
import com.microservice.conference_service.repo.ConferenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class ConferenceMapper {

    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private ConferenceRepo conferenceRepo;

    public ConferenceDTO fromConference(Conference conference) {
        if (conference == null) {
            return null;
        }

        ConferenceDTO conferenceDTO = ConferenceDTO.builder()
                .title(conference.getTitle())
                .type(conference.getType())
                .date(conference.getDate())
                .duration(conference.getDuration())
                .inscription(conference.getInscription())
                .score(conference.getScore())
                .keynote(conference.getKeynote()) // Assuming keynote is already populated
                .reviews(conference.getReviews() != null
                        ? conference.getReviews().stream()
                        .map(reviewMapper::fromReview)
                        .collect(Collectors.toList())
                        : Collections.emptyList())
                .build();

        return conferenceDTO;
    }
}
