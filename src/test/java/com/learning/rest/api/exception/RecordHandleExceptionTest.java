package com.learning.rest.api.exception;

import com.learning.rest.api.exception.handler.RecordExceptionHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class RecordHandleExceptionTest {

    private RecordExceptionHandler recordExceptionHandler;


    @BeforeEach
    public void setUp() {
        recordExceptionHandler = new RecordExceptionHandler();
    }

    @Test
    public void testHandleNoRecordFoudException() {
        NoRecordFoundException noRecordFoundException = new NoRecordFoundException("No Cards Available");

        ResponseEntity<ErrorResponse> responseEntity = recordExceptionHandler
                .noRecordFoundExceptionHandler(noRecordFoundException);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);

        assertEquals(responseEntity.getBody().getErrorMessage(), "No Cards Available");
        assertEquals(responseEntity.getBody().getErrorCode(), "API_02_EMPTY");
    }


    @Test
    public void testHandlGlobleExcpetionHandler() {
        Exception exception = mock(Exception.class);

        ResponseEntity<ErrorResponse> responseEntity = recordExceptionHandler
                .globalExcpetionHandler(exception);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        assertEquals(responseEntity.getBody().getErrorCode(), "API_03_ERROR");

    }
}