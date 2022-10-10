package com.example.cultruemates.repository;

import com.example.cultruemates.domain.MovieDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDetailsRepository extends JpaRepository<MovieDetails, String> {
}
