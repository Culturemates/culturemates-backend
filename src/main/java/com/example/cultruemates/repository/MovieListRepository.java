package com.example.cultruemates.repository;

import com.example.cultruemates.domain.MovieList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.QueryHint;
import java.util.List;

public interface MovieListRepository extends JpaRepository<MovieList, Long> {

    @QueryHints(value = @QueryHint(name = "org.hibernate.readOnly", value = "true"))
    List<MovieList> findTop10ByOrderByUserRatingDesc();

    boolean existsByMovieName(String movieName);

    List<MovieList> findByMovieName(String movieName);

    List<MovieList> findAllByOrderById();

    @Query("select distinct movielist from MovieList movielist "
            + "where movielist.screenEndPeriod >= :nowTime "
            + "and movielist.screenStartPeriod <= :nowTime "
            + "order by movielist.screenEndPeriod desc")
    @QueryHints(value = @QueryHint(name = "org.hibernate.readOnly", value = "true"))
    List<MovieList> findCurrentMovieList(@Param("nowTime") int nowTime);

    @Query("select distinct movielist from MovieList movielist "
            + "where movielist.screenStartPeriod >= :nowTime "
            + "order by movielist.screenEndPeriod desc")
    @QueryHints(value = @QueryHint(name = "org.hibernate.readOnly", value = "true"))
    List<MovieList> findExpectedMovieList(@Param("nowTime") int nowTime);
}