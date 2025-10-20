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
    public List<KeynoteDTO> getKeynotes(){
        List<Keynote> keynoteList = keynoteRepo.findAll();
        List<KeynoteDTO> result = new ArrayList<>();
        keynoteList.forEach(keynote -> {
            KeynoteDTO mappedItem = keynoteMapper.fromKeynote(keynote);
            result.add(mappedItem);
        });
        return result;
    }

    @GetMapping(path = "/keynote/{id}")
    public KeynoteDTO getKeynoteById(@PathVariable String id) {
        Keynote item = keynoteRepo.findById(id).orElse(null);
        return keynoteMapper.fromKeynote(item);
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
    public KeynoteDTO AddNewKeynote(@RequestBody KeynoteDTO newItem){
        Keynote item = Keynote.builder()
                .nom(newItem.getNom())
                .prenom(newItem.getPrenom())
                .email(newItem.getEmail())
                .function(newItem.getFunction())
                .build();
        keynoteRepo.save(item);
        return keynoteMapper.fromKeynote(item);
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
