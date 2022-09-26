package com.example.cultruemates.service;

import com.example.cultruemates.dto.MovieListResponse;
import com.example.cultruemates.repository.MovieListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieListService {

    private final MovieListRepository movieListRepository;

    @Transactional(readOnly = true)
    public List<MovieListResponse> findMovieListByUserRating() {
        List<MovieListResponse> movieListResponses = movieListRepository.findTop10ByOrderByUserRatingDesc().stream()
                .map(movieList -> new MovieListResponse(
                        movieList.getId(),
                        movieList.getMovieName(),
                        movieList.getImgurl(),
                        movieList.getUserRating()))
                .collect(Collectors.toList());

        return movieListResponses;
    }
}
