package com.example.cultruemates.excpetion;

public class NotMovieExistsException extends RuntimeException{

    public NotMovieExistsException(String message) {
        super(message);
    }
}
