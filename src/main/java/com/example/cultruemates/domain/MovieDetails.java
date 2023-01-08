package com.example.cultruemates.domain;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MovieDetails {

    @Id
    private String movieCd;
    private String movieNm;
    private String movieNmEn;
    private String showTm;
    private int createYear;
    private String openDt;

    @Lob
    private String synopsis;
    private String createStatus;
    private String type;
    private String createCountry;
    private String imgurl;
    private String audits;

    private String director;

    @Lob
    private String actors;

    @Lob
    private String staffs;

    @OneToOne(mappedBy = "movieDetails")
    private MovieList movieList;

    @OneToOne(mappedBy = "movieDetails")
    private BoxOfficeMovie boxOfficeMovie;

    @OneToMany(mappedBy = "movieDetails", cascade = CascadeType.ALL)
    private List<MovieDetailsCompany> movieDetailsCompany = new ArrayList<>();

    @Builder
    public MovieDetails(String movieCd, String movieNm, String movieNmEn, String showTm, int createYear, String openDt, String synopsis,
                        String createStatus, String type, String createCountry, String imgurl, String audits, String director,
                        String actors, String staffs) {
        this.movieCd = movieCd;
        this.movieNm = movieNm;
        this.movieNmEn = movieNmEn;
        this.showTm = showTm;
        this.createYear = createYear;
        this.openDt = openDt;
        this.synopsis = synopsis;
        this.createStatus = createStatus;
        this.type = type;
        this.createCountry = createCountry;
        this.imgurl = imgurl;
        this.audits = audits;
        this.director = director;
        this.actors = actors;
        this.staffs = staffs;
    }

    public void addMovieList(MovieList movieList){
        this.movieList = movieList;
        movieList.addMovieDetails(this);
    }
}
