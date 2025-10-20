package com.microservice.conference_service.web;

import com.microservice.conference_service.feign.KeynoteRestClient;
import com.microservice.conference_service.mapper.ConferenceMapper;
import com.microservice.conference_service.repo.ConferenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConferenceRestController {
    @Autowired
    private ConferenceRepo conferenceRepo;
    @Autowired
    private ConferenceMapper conferenceMapper;
    @Autowired
    private KeynoteRestClient keynoteRestClient;

    @GetMapping(path = "/")
    public String get(){
        return "Helaty";
    }
}
