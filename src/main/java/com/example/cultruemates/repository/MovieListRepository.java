package com.example.cultruemates.repository;

import com.example.cultruemates.domain.MovieList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieListRepository extends JpaRepository<MovieList, Long> {
}