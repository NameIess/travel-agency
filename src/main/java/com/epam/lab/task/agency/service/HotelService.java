package com.epam.lab.task.agency.service;

import com.epam.lab.task.agency.entity.Hotel;
import com.epam.lab.task.agency.repository.specification.EntitySpecification;

import java.util.Collection;

/**
 * Contains basic operation to interact with hotel.
 */
public interface HotelService {
    /**
     * Saves the particular hotel.
     *
     * @param hotel Particular hotel to be saved
     * @return Stored hotel instance
     */
    Hotel save(Hotel hotel);

    /**
     * Deletes the particular hotel.
     *
     * @param entitySpecification Particular hotel specification with a condition
     */
    void delete(EntitySpecification<Hotel> entitySpecification);

    /**
     * Updates the particular hotel.
     *
     * @param hotel Particular updated hotel to be saved
     * @return Stored updated hotel instance
     */
    Hotel update(Hotel hotel);

    /**
     * Finds the hotel by hotel specification.
     *
     * @param entitySpecification Particular entity specification witch a condition
     * @return Stored hotel instance that satisfies specification requirements
     */
    Hotel findOne(EntitySpecification<Hotel> entitySpecification);

    /**
     * Finds the hotel collection by hotel specification.
     *
     * @param entitySpecification Particular entity specification witch a condition
     * @return Stored hotels collection that satisfies specification requirements
     */
    Collection<Hotel> findAll(EntitySpecification<Hotel> entitySpecification);
}
