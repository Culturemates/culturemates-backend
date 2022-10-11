package com.example.cultruemates.repository;

import com.example.cultruemates.domain.MovieDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieDetailsRepository extends JpaRepository<MovieDetails, String> {

    Optional<MovieDetails> findByMovieCd(String movieCd);
}
