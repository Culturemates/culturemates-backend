package com.example.cultruemates.domain;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Company {

    @Id
    private String companyCd;
    private String companyNm;
    private String companyNmEn;
    private String companyPartNm;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<MovieDetailsCompany> movieDetailsCompany = new ArrayList<>();

    @Builder
    public Company(String companyCd, String companyNm, String companyNmEn, String companyPartNm){
        this.companyCd = companyCd;
        this.companyNm = companyNm;
        this.companyNmEn = companyNmEn;
        this.companyPartNm = companyPartNm;
    }
}
