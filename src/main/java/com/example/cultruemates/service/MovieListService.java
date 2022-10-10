package com.example.cultruemates.service;

import com.example.cultruemates.domain.MovieList;
import com.example.cultruemates.dto.CurrentMovieListResponse;
import com.example.cultruemates.dto.MovieListResponse;
import com.example.cultruemates.repository.MovieListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
                        movieList.getMovieCd(),
                        movieList.getMovieName(),
                        movieList.getImgurl(),
                        movieList.getUserRating()))
                .collect(Collectors.toList());

        return movieListResponses;
    }


    @Transactional(readOnly = true)
    public List<CurrentMovieListResponse> findCurrentMovieList(){
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        int nowTime = Integer.parseInt(now.format(formatter));

        List<CurrentMovieListResponse> responses = movieListRepository.findCurrentMovieList(nowTime).stream()
                .map((resp)-> new CurrentMovieListResponse(
                        resp.getMovieCd(),
                        resp.getMovieName(),
                        resp.getImgurl(),
                        resp.getUserRating(),
                        resp.getScreenStartPeriod(),
                        resp.getScreenEndPeriod()
                )).collect(Collectors.toList());

        return responses;
    }
}
