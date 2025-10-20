package com.microservice.conference_service.repo;

import com.microservice.conference_service.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review,Long> {
}
