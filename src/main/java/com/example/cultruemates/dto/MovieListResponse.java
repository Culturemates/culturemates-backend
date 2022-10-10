package com.example.cultruemates.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class MovieListResponse {
    private String movieCd;
    private String title;
    private String imgurl;
    private float userRating;
}
