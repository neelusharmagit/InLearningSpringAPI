package com.learning.rest.api.controller;

import java.util.List;

import com.learning.rest.api.model.Creditcard;
import com.learning.rest.api.service.InLearningService;
 git aimport org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/v1")
public class InLearningAPIController {
    @Autowired
    private InLearningService inLearningService;

    @GetMapping(path = "/getRecords", produces = "application/json")
    public ResponseEntity<Creditcard> getEmployees() {
        List<Creditcard> learningRecords = inLearningService.getAllRecords();
        return new ResponseEntity(learningRecords, HttpStatus.OK);
        }


    }

