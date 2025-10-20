package com.microservice.conference_service.feign;

import com.microservice.conference_service.models.Keynote;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "keynote-service")
public interface KeynoteRestClient {
    @GetMapping("api/keynotes/{id}")
    Keynote findKeynoteById(@PathVariable String id);
    @GetMapping("api/keynotes")
    List<Keynote> findAllKeynote();
}
