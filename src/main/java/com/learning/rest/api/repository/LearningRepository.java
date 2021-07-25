package com.learning.rest.api.repository;

import com.learning.rest.api.model.Creditcard;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LearningRepository extends JpaRepository<Creditcard, Long> {

}