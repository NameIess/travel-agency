package com.epam.lab.task.agency.repository;

import com.epam.lab.task.agency.entity.Country;
import com.epam.lab.task.agency.repository.generic.PersistentRepository;

/**
 * Contains basic operation to interact with country data source.
 */
public interface CountryRepository extends PersistentRepository<Country, Long> {
}
