package com.spring.demo.repository;

import com.spring.demo.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    @Query("select c from Country c")
    Optional<List<Country>> getAll();
}
