package com.example.cultruemates.repository;

import com.example.cultruemates.domain.MovieList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class MovieListRepositoryTest extends RepositoryTest{

    @Autowired
    private MovieListRepository movieListRepository;

    @Test
    void findTop10ByOrderByUserRatingDesc(){
        //when
        List<MovieList> movieLists = movieListRepository.findTop10ByOrderByUserRatingDesc();

        //then
        assertThat(movieLists).hasSize(10);
        for (int i = 0; i < 10; i++) {
            System.out.println("제목: " + movieLists.get(i).getMovieName() + ", 평점: " + movieLists.get(i).getUserRating());
        }
    }

    @Test
    void findCurrentMovieList(){
        //given
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        int nowTime = Integer.parseInt(now.format(formatter));
        System.out.println(nowTime);

        //when
        List<MovieList> responses = movieListRepository.findCurrentMovieList(nowTime);

        //then
        System.out.println("----------------결과");
        System.out.println(responses.stream().count());
        for (int i = 0; i < responses.stream().count(); i++) {
            boolean result = responses.get(i).getScreenEndPeriod() >= nowTime && responses.get(i).getScreenStartPeriod() <= nowTime;
            assertThat(result).isTrue();
        }
    }
}
