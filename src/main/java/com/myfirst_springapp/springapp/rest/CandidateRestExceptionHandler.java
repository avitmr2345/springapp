package com.myfirst_springapp.springapp.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.myfirst_springapp.springapp.entity.CandidateErrorResponse;

@ControllerAdvice
public class CandidateRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CandidateErrorResponse> handleException(CandidateNotFoundException exception) {
        CandidateErrorResponse error = new CandidateErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CandidateErrorResponse> handleException(Exception exception) {
        CandidateErrorResponse error = new CandidateErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Bad Request: Please provide an integer");
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
