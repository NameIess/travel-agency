package com.epam.lab.task.agency.repository;

import com.epam.lab.task.agency.entity.User;
import com.epam.lab.task.agency.repository.generic.PersistentRepository;

/**
 * Contains basic operation to interact with user data source.
 */
public interface UserRepository extends PersistentRepository<User, Long> {
}
