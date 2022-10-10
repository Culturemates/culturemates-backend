package com.example.cultruemates.repository;

import com.example.cultruemates.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
}
