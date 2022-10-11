package com.example.cultruemates.controller;

import com.example.cultruemates.dto.ErrorResponse;
import com.example.cultruemates.excpetion.NotMovieExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(NotMovieExistsException.class)
    public ResponseEntity<ErrorResponse> handleNotMovieExistsException(NotMovieExistsException e) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new ErrorResponse(e.getMessage()));
    }
}
