package com.spring.demo.service.impl;

import com.spring.demo.model.Country;
import com.spring.demo.repository.CountryRepository;
import com.spring.demo.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country create(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> createAll(Iterable<Country> countries) {
        return countryRepository.saveAll(countries);
    }

    @Override
    public Optional<List<Country>> getAll() {
        return countryRepository.getAll();
    }
}
