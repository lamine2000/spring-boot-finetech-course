package com.spring.demo.service;

import com.spring.demo.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    public Country create(Country country);

    public List<Country> createAll(Iterable<Country> countries);

    public Optional<List<Country>> getAll();
}
