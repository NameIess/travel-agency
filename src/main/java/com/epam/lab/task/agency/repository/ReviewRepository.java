package com.epam.lab.task.agency.repository;

import com.epam.lab.task.agency.entity.Review;
import com.epam.lab.task.agency.repository.generic.PersistentRepository;

/**
 * Contains basic operation to interact with review data source.
 */
public interface ReviewRepository extends PersistentRepository<Review, Long> {
}
