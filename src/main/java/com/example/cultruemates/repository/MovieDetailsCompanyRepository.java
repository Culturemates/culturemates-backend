package com.example.cultruemates.repository;

import com.example.cultruemates.domain.Company;
import com.example.cultruemates.domain.MovieDetailsCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.QueryHint;
import java.util.List;

public interface MovieDetailsCompanyRepository extends JpaRepository<MovieDetailsCompany, Long> {

    @Query("select distinct company from MovieDetailsCompany mc " +
            "left join mc.company company "
            + "where mc.movieDetails.movieCd = :movieCd")
    @QueryHints(value = @QueryHint(name = "org.hibernate.readOnly", value = "true"))
    List<Company> findCompanyListByMovieCd(@Param("movieCd") String movieCd);
}
