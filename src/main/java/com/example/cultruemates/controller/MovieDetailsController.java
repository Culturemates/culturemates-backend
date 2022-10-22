package com.example.cultruemates.controller;

import com.example.cultruemates.dto.MovieDetailsResponse;
import com.example.cultruemates.service.MovieDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movie/details")
public class MovieDetailsController {

    private final MovieDetailsService movieDetailsService;

    @GetMapping("/{code}")
    public ResponseEntity<MovieDetailsResponse> movieDetails(@PathVariable("code") String movieCode) {
        MovieDetailsResponse movieDetailsResponse = movieDetailsService.findMovieDetails(movieCode);

        return ResponseEntity.ok()
                .body(movieDetailsResponse);

    }
}
