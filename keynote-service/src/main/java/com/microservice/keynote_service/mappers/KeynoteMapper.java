package com.microservice.keynote_service.mappers;

import com.microservice.keynote_service.dtos.KeynoteDTO;
import com.microservice.keynote_service.entities.Keynote;
import com.microservice.keynote_service.repo.KeynoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KeynoteMapper {
    @Autowired
    private KeynoteRepo keynoteRepo;

    public KeynoteDTO fromKeynote(Keynote keynote){
        if(keynote == null)
            return null;
        KeynoteDTO keynoteDTO = KeynoteDTO.builder()
                .email(keynote.getEmail())
                .nom(keynote.getNom())
                .prenom(keynote.getPrenom())
                .function(keynote.getFunction())
                .build();
        return keynoteDTO;
    }
}
