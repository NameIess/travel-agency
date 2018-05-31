package com.epam.lab.task.agency.repository;

import com.epam.lab.task.agency.entity.Hotel;
import com.epam.lab.task.agency.repository.generic.PersistentRepository;

/**
 * Contains basic operation to interact with hotel data source.
 */
public interface HotelRepository extends PersistentRepository<Hotel, Long> {
}
