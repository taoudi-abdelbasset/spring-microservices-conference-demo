package com.microservice.conference_service.dtos;

import com.microservice.conference_service.entities.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDTO {
    private Long id;
    private Date createdAt;
    private String text;
    private Double note;
    private Long conferenceId;
}
