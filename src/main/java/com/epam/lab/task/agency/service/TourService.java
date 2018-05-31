package com.epam.lab.task.agency.service;

import com.epam.lab.task.agency.entity.Tour;
import com.epam.lab.task.agency.repository.specification.EntitySpecification;

import java.util.Collection;

/**
 * Contains basic operation to interact with tour.
 */
public interface TourService {
    /**
     * Saves the particular tour.
     *
     * @param tour Particular tour to be saved
     * @return Stored tour instance
     */
    Tour save(Tour tour);

    /**
     * Deletes the particular tour.
     *
     * @param entitySpecification Particular tour specification with a condition
     */
    void delete(EntitySpecification<Tour> entitySpecification);

    /**
     * Updates the particular tour.
     *
     * @param tour Particular updated tour to be saved
     * @return Stored updated tour instance
     */
    Tour update(Tour tour);

    /**
     * Finds the tour by tour specification.
     *
     * @param entitySpecification Particular entity specification witch a condition
     * @return Stored tour instance that satisfies specification requirements
     */
    Tour findOne(EntitySpecification<Tour> entitySpecification);

    /**
     * Finds the tour collection by tour specification.
     *
     * @param entitySpecification Particular entity specification witch a condition
     * @return Stored tours collection that satisfies specification requirements
     */
    Collection<Tour> findAll(EntitySpecification<Tour> entitySpecification);
}
