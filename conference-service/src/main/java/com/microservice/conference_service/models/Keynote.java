package com.microservice.conference_service.models;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Keynote {
    private String nom;
    private String prenom;
    private String email;
    private String function;
}
