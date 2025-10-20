package com.microservice.keynote_service.web;

import com.microservice.keynote_service.dtos.KeynoteDTO;
import com.microservice.keynote_service.entities.Keynote;
import com.microservice.keynote_service.expections.KeynoteNotFoundException;
import com.microservice.keynote_service.mappers.KeynoteMapper;
import com.microservice.keynote_service.repo.KeynoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class KeynoteController {
    @Autowired
    private KeynoteRepo keynoteRepo;
    @Autowired
    private KeynoteMapper keynoteMapper;

    @GetMapping(path = "/keynote")
    public List<Keynote> getKeynotes(){
        return keynoteRepo.findAll();
    }

    @GetMapping(path = "/keynote/{id}")
    public Keynote getKeynoteById(@PathVariable String id) {
        return keynoteRepo.findById(id).orElse(null);
    }

    @PutMapping(path = "/keynote/{id}")
    public Keynote updateKeynote(@PathVariable String id ,@RequestBody KeynoteDTO newItem){
        Keynote item = keynoteRepo.findById(id).orElse(null);
        if(item == null)
            return null;

        if (newItem.getEmail() != null)
            item.setEmail(newItem.getEmail());
        if (newItem.getNom() != null)
            item.setNom(newItem.getNom());
        if (newItem.getPrenom() != null)
            item.setPrenom(newItem.getPrenom());
        if (newItem.getFunction() != null)
            item.setFunction(newItem.getFunction());

        keynoteRepo.save(item);
        return item;
    }

    @PostMapping(path = "/keynote")
    public Keynote AddNewKeynote(@RequestBody KeynoteDTO newItem){
        Keynote item = Keynote.builder()
                .nom(newItem.getNom())
                .prenom(newItem.getPrenom())
                .email(newItem.getEmail())
                .function(newItem.getFunction())
                .build();
        keynoteRepo.save(item);
        return item;
    }

    @DeleteMapping(path = "/keynote/{id}")
    public boolean deleteKeynoteById(@PathVariable String id){
        try{
            keynoteRepo.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
