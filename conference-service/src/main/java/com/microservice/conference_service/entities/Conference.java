package com.microservice.conference_service.entities;

import com.microservice.conference_service.enums.ConferenceType;
import com.microservice.conference_service.models.Keynote;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor
@NoArgsConstructor
@Builder
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private ConferenceType type;
    private Date date;
    private Long duration;
    private Long inscription;
    private Double score;
    private String keynoteId;
    @Transient
    private Keynote keynote;
    @OneToMany(mappedBy = "conference") // Updated to match the field name in Review
    private List<Review> reviews;
}
