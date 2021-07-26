package com.learning.rest.api.service;


import com.learning.rest.api.exception.NoRecordFoundException;
import com.learning.rest.api.model.Creditcard;
import com.learning.rest.api.repository.LearningRepository;
import com.learning.rest.api.service.InLearningService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class InLearningServiceTest {

    @Mock
    LearningRepository creditcardRepository;

    @InjectMocks
    InLearningService inLearningService;

    List<Creditcard> creditCardList = new ArrayList<>();
    List<Creditcard> creditCardLisEmpty = new ArrayList<>();
    Creditcard creditcardA;
    Creditcard creditcardB;
    Creditcard creditcardC;
    Creditcard creditcardD;


    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        creditcardA = new Creditcard("41111111111111111","validCardA", 500.00);
        creditcardB = new Creditcard("20202020","validCardB", 500.00);
        creditcardC = new Creditcard("444BB56","validCardC", -900.00);
        creditcardD = new Creditcard("411111111111111111111111111111111111111111","validCardA", 500.00);
        creditCardList = new ArrayList<>();
        creditCardList.add(creditcardA);
        creditCardList.add(creditcardB);
        creditCardList.add(creditcardC);
    }

    @Test
    public void testValidfindAll(){
        Mockito.when(creditcardRepository.findAll()).thenReturn(creditCardList);
        List<Creditcard> creditCard = inLearningService.getAllRecords();
        assertFalse(creditCard.isEmpty());
        assertEquals(3,creditCardList.size());
    }



    @Test
    void testInValidfindAll() {
        Mockito.when(creditcardRepository.findAll()).thenReturn(creditCardLisEmpty);
        NoRecordFoundException thrown = assertThrows(
                NoRecordFoundException.class,
                () -> inLearningService.getAllRecords(),
                "No Cards Available"
        );
    }

}