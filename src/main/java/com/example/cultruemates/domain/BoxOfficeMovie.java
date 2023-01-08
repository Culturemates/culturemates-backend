package com.example.cultruemates.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BoxOfficeMovie {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_code")
    private MovieDetails movieDetails;

    private Long openDt;

    private Long audienceCount;

    private String imgurl;

    @Builder
    void BoxOfficeMovie(Long openDt, Long audienceCount, String imgurl){
        this.openDt = openDt;
        this.audienceCount = audienceCount;
        this.imgurl = imgurl;
    }
}
