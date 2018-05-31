package com.epam.lab.task.agency.repository;

import com.epam.lab.task.agency.entity.Tour;
import com.epam.lab.task.agency.repository.generic.PersistentRepository;

/**
 * Contains basic operation to interact with tour data source.
 */
public interface TourRepository extends PersistentRepository<Tour, Long> {
}
