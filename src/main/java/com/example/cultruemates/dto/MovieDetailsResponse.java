package com.example.cultruemates.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class MovieDetailsResponse {
    private String movieCd;
    private String movieNm;
    private String movieNmEn;
    private String showTm;
    private String openDt;
    private String type;
    private String createCountry;
    private String imgurl;
    private String audits;
    private String driector;
    private String actors;
    private String staffs;
    private String createStatus;
    private List<CompanyByMovie> companyByMovies;
}
