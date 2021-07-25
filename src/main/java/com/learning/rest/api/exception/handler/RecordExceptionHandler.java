package com.learning.rest.api.exception.handler;

import com.learning.rest.api.exception.ErrorResponse;
import com.learning.rest.api.exception.NoRecordFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class RecordExceptionHandler {
    /**
     * Records not found exception response entity.
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(NoRecordFoundException.class)
    public ResponseEntity<ErrorResponse> noRecordFoundExceptionHandler(
            NoRecordFoundException ex) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode("API_02_EMPTY");
        response.setErrorMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
    }

    /**
     * Globle excpetion handler response entity.
     * @param ex      the ex
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> globalExcpetionHandler(Exception ex) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode("API_03_ERROR");
        response.setErrorMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

