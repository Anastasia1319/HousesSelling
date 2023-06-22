package com.oleshko.HousesSelling.web.controller;

import com.oleshko.HousesSelling.platform.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ErrorHandler {

    @ExceptionHandler
    public ResponseEntity notFoundHandler(NotFoundException e) {
        log.error("Object can't be found. Cause: ", e);
        return new ResponseEntity("Sorry, we couldn't find the information you need.",
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity exceptionHandler(Exception e) {
        log.error("Unexpected error. Cause: ", e);
        return new ResponseEntity("Sorry! Unexpected error. We are workig on...",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
