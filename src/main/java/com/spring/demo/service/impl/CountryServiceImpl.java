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

    //dependancy injection
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country create(Country country) {
        return countryRepository.save(country);
    }

    //The Iterable<?> interface is extended by the Collection<?> interface
    //which is extended bythe List<?> interface
    //which is implemented by the following classes:
    /*
        AbstractList
        AbstractSequentialList
        ArrayList
        AttributeList
        CopyOnWriteArrayList
        LinkedList
        RoleList
        RoleUnresolvedList
        Stack
        Vector
        ...
    */
    @Override
    public List<Country> createAll(Iterable<Country> countries) {
        return countryRepository.saveAll(countries);
    }

    @Override
    public Optional<List<Country>> getAll() {
        return countryRepository.getAll();
    }
}
