package com.microservice.conference_service.dtos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.microservice.conference_service.enums.ConferenceType;
import com.microservice.conference_service.models.Keynote;
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
public class ConferenceDTO {
    private String title;
    private ConferenceType type;
    private Date date;
    private Long duration;
    private Long inscription;
    private Double score;
    private Keynote keynote;
    @JsonManagedReference
    private List<ReviewDTO> reviews;
}
