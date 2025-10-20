package com.microservice.keynote_service.repo;

import com.microservice.keynote_service.entities.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface KeynoteRepo extends JpaRepository<Keynote,String> {
}
