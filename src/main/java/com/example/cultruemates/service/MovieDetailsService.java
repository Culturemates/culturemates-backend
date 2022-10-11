package com.example.cultruemates.service;

import com.example.cultruemates.domain.Company;
import com.example.cultruemates.domain.MovieDetails;
import com.example.cultruemates.domain.MovieList;
import com.example.cultruemates.dto.CompanyByMovie;
import com.example.cultruemates.dto.MovieDetailsResponse;
import com.example.cultruemates.excpetion.NotMovieExistsException;
import com.example.cultruemates.repository.MovieDetailsCompanyRepository;
import com.example.cultruemates.repository.MovieDetailsRepository;
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
public class MovieDetailsService {

    private final MovieDetailsRepository movieDetailsRepository;

    private final MovieListRepository movieListRepository;
    private final MovieDetailsCompanyRepository movieDetailsCompanyRepository;

    @Transactional(readOnly = true)
    public MovieDetailsResponse findmovieDetaiils(String movieCode) {
        MovieDetails movieDetails = movieDetailsRepository.findByMovieCd(movieCode)
                .orElseThrow(() -> new NotMovieExistsException("해당되는 영화가 존재하지 않습니다."));
        MovieList movieList = movieListRepository.findByMovieCd(movieCode)
                .orElseThrow(() -> new NotMovieExistsException("해당되는 영화가 존재하지 않습니다."));
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        int nowTime = Integer.parseInt(now.format(formatter));
        String openStatus = "";
        if(movieList.getScreenEndPeriod() >= nowTime && movieList.getScreenStartPeriod() <= nowTime){
            openStatus = "개봉중";
        } else if(movieList.getScreenEndPeriod() >= nowTime){
            openStatus = "개봉예정";
        } else {
            openStatus = "미상영";
        }

        List<Company> companies = movieDetailsCompanyRepository.findCompanyListByMovieCd(movieCode);
        List<CompanyByMovie> companyByMovies = companies.stream()
                .map((company) -> new CompanyByMovie(
                        company.getCompanyCd(),
                        company.getCompanyNm(),
                        company.getCompanyNmEn(),
                        company.getCompanyPartNm())).collect(Collectors.toList());

        return new MovieDetailsResponse(
                movieDetails.getMovieCd(),
                movieDetails.getMovieNm(),
                movieDetails.getMovieNmEn(),
                movieDetails.getShowTm(),
                movieDetails.getOpenDt(),
                movieDetails.getType(),
                movieDetails.getCreateCountry(),
                movieDetails.getImgurl(),
                movieDetails.getAudits(),
                movieDetails.getDirector(),
                movieDetails.getActors(),
                movieDetails.getStaffs(),
                openStatus,
                companyByMovies
        );
    }
}
