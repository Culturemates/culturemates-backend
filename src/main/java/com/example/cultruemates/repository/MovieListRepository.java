package com.example.cultruemates.repository;

import com.example.cultruemates.domain.MovieList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;

public interface MovieListRepository extends JpaRepository<MovieList, Long> {

    @QueryHints(value = @QueryHint(name = "org.hibernate.readOnly", value = "true"))
    List<MovieList> findTop10ByOrderByUserRatingDesc();
}