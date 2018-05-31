package com.epam.lab.task.agency.service;

import com.epam.lab.task.agency.entity.User;
import com.epam.lab.task.agency.repository.specification.EntitySpecification;

import java.util.Collection;

/**
 * Contains basic operation to interact with user.
 */
public interface UserService {
    /**
     * Saves the particular user.
     *
     * @param user Particular user to be saved
     * @return Stored user instance
     */
    User save(User user);

    /**
     * Deletes the particular user.
     *
     * @param entitySpecification Particular user specification with a condition
     */
    void delete(EntitySpecification<User> entitySpecification);

    /**
     * Updates the particular user.
     *
     * @param user Particular updated user to be saved
     * @return Stored updated user instance
     */
    User update(User user);

    /**
     * Finds the user by user specification.
     *
     * @param entitySpecification Particular entity specification witch a condition
     * @return Stored user instance that satisfies specification requirements
     */
    User findOne(EntitySpecification<User> entitySpecification);

    /**
     * Finds the user collection by user specification.
     *
     * @param entitySpecification Particular entity specification witch a condition
     * @return Stored users collection that satisfies specification requirements
     */
    Collection<User> findAll(EntitySpecification<User> entitySpecification);
}
