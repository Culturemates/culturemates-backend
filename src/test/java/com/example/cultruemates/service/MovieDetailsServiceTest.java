package com.example.cultruemates.service;

import com.example.cultruemates.dto.MovieDetailsResponse;
import com.example.cultruemates.excpetion.NotMovieExistsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieDetailsServiceTest {

    @Autowired
    private MovieDetailsService movieDetailsService;

    @Test
    @DisplayName("영화 상세 정보 조회")
    void findMovieDetails(){
        //given
        String movieCode = "20226823";
        //then
        MovieDetailsResponse movieDetailsResponse = movieDetailsService.findMovieDetails(movieCode);
        //when
        assertThat(movieDetailsResponse.getMovieCd()).isEqualTo(movieCode);
    }

    @Test
    @DisplayName("영화 상세 정보 조회 - 영화코드에 해당되는 영화가 존재하지 않는 경우")
    void findMovieDetails_IfNotMovieExists() {
        //given
        String movieCode = "1111111111111111111ㅋㅋㅋㅋㅋㅇㅇㅇ1";
        //when & then
        assertThatThrownBy(
                () -> movieDetailsService.findMovieDetails(movieCode))
                .isInstanceOf(NotMovieExistsException.class);
    }
}
