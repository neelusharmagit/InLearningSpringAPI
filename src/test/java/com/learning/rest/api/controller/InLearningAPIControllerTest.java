
package com.learning.rest.api.controller;


import com.learning.rest.api.model.Creditcard;
import com.learning.rest.api.service.InLearningService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = InLearningAPIController.class)
public class InLearningAPIControllerTest {



    @Autowired
    private WebApplicationContext context;

  /*  @Autowired
    private Filter springSecurityFilterChain;*/

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InLearningService inLearningService;

    List<Creditcard> creditCardList;

    @Test
    public void listAllCards() throws Exception {
        Mockito.when(
                inLearningService.getAllRecords()).thenReturn(creditCardList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/v1/getRecords").accept(
                MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }




}
