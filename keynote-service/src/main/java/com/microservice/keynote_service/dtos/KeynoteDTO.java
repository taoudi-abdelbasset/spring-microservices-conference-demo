package com.microservice.keynote_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class KeynoteDTO {
    private String nom;
    private String prenom;
    private String email;
    private String function;
}
