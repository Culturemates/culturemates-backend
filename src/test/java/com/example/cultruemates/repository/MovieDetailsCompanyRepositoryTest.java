package com.example.cultruemates.repository;

import com.example.cultruemates.domain.Company;
import com.example.cultruemates.domain.MovieDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieDetailsCompanyRepositoryTest extends RepositoryTest {

    @Autowired
    private MovieDetailsCompanyRepository movieDetailsCompanyRepository;

    @Autowired
    private MovieDetailsRepository movieDetailsRepository;

    @Test
    void findCompanyListByMovieCd() {
        //given
        String movieCode = "20226823";
        MovieDetails movieDetails = movieDetailsRepository.findByMovieCd(movieCode).orElseThrow(() -> new RuntimeException("예외 발생"));
        //then
        List<Company> companies = movieDetailsCompanyRepository.findCompanyListByMovieCd(movieCode);
        //when
        assertThat(movieDetails.getMovieDetailsCompany()).hasSize(companies.size());
    }
}
