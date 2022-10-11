package com.example.cultruemates.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class CompanyByMovie {
    private String companyCd;
    private String name;
    private String nameEn;
    private String companyPartName;
}
