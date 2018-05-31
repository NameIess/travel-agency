package com.epam.lab.task.agency.service;

import com.epam.lab.task.agency.entity.Review;
import com.epam.lab.task.agency.repository.specification.EntitySpecification;

import java.util.Collection;

/**
 * Contains basic operation to interact with review.
 */
public interface ReviewService {
    /**
     * Saves the particular review.
     *
     * @param review Particular review to be saved
     * @return Stored review instance
     */
    Review save(Review review);

    /**
     * Deletes the particular review.
     *
     * @param entitySpecification Particular review specification with a condition
     */
    void delete(EntitySpecification<Review> entitySpecification);

    /**
     * Updates the particular review.
     *
     * @param review Particular updated review to be saved
     * @return Stored updated review instance
     */
    Review update(Review review);

    /**
     * Finds the review by review specification.
     *
     * @param entitySpecification Particular entity specification witch a condition
     * @return Stored review instance that satisfies specification requirements
     */
    Review findOne(EntitySpecification<Review> entitySpecification);

    /**
     * Finds the review collection by review specification.
     *
     * @param entitySpecification Particular entity specification witch a condition
     * @return Stored reviews collection that satisfies specification requirements
     */
    Collection<Review> findAll(EntitySpecification<Review> entitySpecification);
}
