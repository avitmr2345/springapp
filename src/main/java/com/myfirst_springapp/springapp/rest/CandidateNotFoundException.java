package com.myfirst_springapp.springapp.rest;

public class CandidateNotFoundException extends RuntimeException {

    public CandidateNotFoundException(String message) {
        super(message);
    }

    public CandidateNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CandidateNotFoundException(Throwable cause) {
        super(cause);
    }

}
