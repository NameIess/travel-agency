package com.epam.lab.task.agency.service;

import com.epam.lab.task.agency.entity.Country;
import com.epam.lab.task.agency.repository.specification.EntitySpecification;

import java.util.Collection;

/**
 * Contains basic operation to interact with country.
 */

public interface CountryService {
    /**
     * Saves the particular country.
     *
     * @param country Particular country to be saved
     * @return Stored country instance
     */
    Country save(Country country);

    /**
     * Deletes the particular country.
     *
     * @param entitySpecification Particular country specification with a condition
     */
    void delete(EntitySpecification<Country> entitySpecification);

    /**
     * Updates the particular country.
     *
     * @param country Particular updated country to be saved
     * @return Stored updated country instance
     */
    Country update(Country country);

    /**
     * Finds the country by country specification.
     *
     * @param entitySpecification Particular entity specification witch a condition
     * @return Stored country instance that satisfies specification requirements
     */
    Country findOne(EntitySpecification<Country> entitySpecification);

    /**
     * Finds the country collection by country specification.
     *
     * @param entitySpecification Particular entity specification witch a condition
     * @return Stored countries collection that satisfies specification requirements
     */
    Collection<Country> findAll(EntitySpecification<Country> entitySpecification);
}
