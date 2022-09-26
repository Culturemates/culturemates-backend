package com.example.cultruemates.repository;

import com.example.cultruemates.domain.MovieList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
}
