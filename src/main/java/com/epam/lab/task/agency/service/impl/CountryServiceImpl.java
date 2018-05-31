package com.epam.lab.task.agency.service.impl;

import com.epam.lab.task.agency.entity.Country;
import com.epam.lab.task.agency.repository.CountryRepository;
import com.epam.lab.task.agency.repository.specification.EntitySpecification;
import com.epam.lab.task.agency.service.CountryService;
import com.epam.lab.task.agency.service.exception.ServiceException;

import java.util.Collection;
import java.util.Optional;

/**
 * Contains basic operations implementation to interact with country.
 */
public class CountryServiceImpl implements CountryService {
    private CountryRepository countryRepository;

    /**
     * Constructor is used to provide an dependencies injection.
     *
     * @param countryRepository Particular ReviewRepository implementation
     */
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country save(Country country) {
        Optional<Country> countryOptional = countryRepository.save(country);
        return countryOptional.orElseThrow(
                () -> new ServiceException("Trouble within save(): optional values is null")
        );
    }

    @Override
    public void delete(EntitySpecification<Country> entitySpecification) {
        Collection<Country> countries = findAll(entitySpecification);
        countryRepository.delete(countries);
    }

    @Override
    public Country update(Country country) {
        Optional<Country> countryOptional = countryRepository.update(country);
        return countryOptional.orElseThrow(
                () -> new ServiceException("Trouble within update(): optional values is null")
        );
    }

    @Override
    public Country findOne(EntitySpecification<Country> entitySpecification) {
        Optional<Country> countryOptional = countryRepository.findOne(entitySpecification);
        return countryOptional.orElseThrow(
                () -> new ServiceException("Trouble within findOne(): optional values is null")
        );
    }

    @Override
    public Collection<Country> findAll(EntitySpecification<Country> entitySpecification) {
        Optional<Collection<Country>> countriesOptional = countryRepository.findAll(entitySpecification);
        return countriesOptional.orElseThrow(
                () -> new ServiceException("Trouble within findAll(): optional values is null")
        );
    }
}
