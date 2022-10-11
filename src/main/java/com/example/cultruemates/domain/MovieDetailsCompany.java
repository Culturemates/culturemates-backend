package com.example.cultruemates.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class MovieDetailsCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_details_id", nullable = false)
    private MovieDetails movieDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Builder
    public MovieDetailsCompany(MovieDetails movieDetails, Company company){
        this.movieDetails = movieDetails;
        this.company = company;
    }
}
