package com.learning.rest.api.service;


import com.learning.rest.api.exception.NoRecordFoundException;
import com.learning.rest.api.model.Creditcard;
import com.learning.rest.api.repository.LearningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InLearningService {

    @Autowired
    private LearningRepository learningRepository;

    public void setLearningRepository(LearningRepository learningRepository) {
        this.learningRepository = learningRepository;
    }


    public List<Creditcard> getAllRecords(){
       List<Creditcard> learningRecords = new ArrayList<>();
       learningRecords = learningRepository.findAll();
        if (learningRecords.isEmpty()) {
            throw new NoRecordFoundException("No Records found");
        }

       return learningRecords;
    }
}
