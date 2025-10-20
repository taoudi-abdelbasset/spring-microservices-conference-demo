package com.microservice.conference_service.repo;

import com.microservice.conference_service.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepo extends JpaRepository<Conference,Long> {
}
