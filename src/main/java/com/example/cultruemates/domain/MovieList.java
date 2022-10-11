package com.example.cultruemates.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "movie_list")
public class MovieList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String movieName;

    private String movieCd;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_code")
    private MovieDetails movieDetails;

    private String movieEnName;

    private int openYear;

    private int createYear;

    private int screenStartPeriod;

    private int screenEndPeriod;

    private String createCountry;

    private String type;

    private String genre;

    private String createStatus;

    private String director;

    private String imgurl;

    private float userRating;

    public void addMovieDetails(MovieDetails movieDetails){
        this.movieDetails = movieDetails;
    }
}