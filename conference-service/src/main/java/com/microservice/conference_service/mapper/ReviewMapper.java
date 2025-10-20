package com.microservice.conference_service.mapper;

import com.microservice.conference_service.dtos.ReviewDTO;
import com.microservice.conference_service.entities.Review;
import com.microservice.conference_service.repo.ConferenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {


    @Autowired
    private ConferenceRepo conferenceRepo;

    public ReviewDTO fromReview(Review review) {
        if (review == null) {
            return null;
        }

        ReviewDTO reviewDTO = ReviewDTO.builder()
                .id(review.getId())
                .createdAt(review.getCreatedAt())
                .text(review.getText())
                .note(review.getNote())
                .conferenceId(review.getConference() != null
                        ? review.getConference().getId()
                        : null)
                .build();

        return reviewDTO;
    }
}