package com.example.cultruemates.controller;

import com.example.cultruemates.dto.CurrentMovieListResponse;
import com.example.cultruemates.dto.ExpectedMovieListResponse;
import com.example.cultruemates.dto.MovieListResponse;
import com.example.cultruemates.service.MovieListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movies")
public class MovieListController {

    private final MovieListService movieListService;

    @GetMapping
    public ResponseEntity<List<MovieListResponse>> findMovieListByUserRating(){
        List<MovieListResponse> movieListResponses = movieListService.findMovieListByUserRating();

        return ResponseEntity.ok()
                .body(movieListResponses);
    }

    @GetMapping("current")
    public ResponseEntity<List<CurrentMovieListResponse>> findCurrrentScreening(){

        List<CurrentMovieListResponse> responses = movieListService.findCurrentMovieList();

        return ResponseEntity.ok()
                .body(responses);
    }

    @GetMapping("expected")
    public ResponseEntity<List<ExpectedMovieListResponse>> findExpectedScreening(){

        List<ExpectedMovieListResponse> responses = movieListService.findExpectedMovieList();

        return ResponseEntity.ok()
                .body(responses);
    }
}
