package com.epam.lab.task.agency.repository.generic;

import com.epam.lab.task.agency.repository.specification.EntitySpecification;

import java.util.Collection;
import java.util.Optional;

/**
 * Contains general operations for interaction with generic entity.
 *
 * @param <T> Domain entity type
 */
public interface GenericRepository<T> {

    /**
     * Saves the particular entity.
     *
     * @param entity Particular domain entity to be saved
     * @return Optional wrapper that may have or not content depending on entity validness
     */
    Optional<T> save(T entity);

    /**
     * Deletes the domain entity.
     *
     * @param entity Particular domain entity to be deleted
     */
    void delete(T entity);

    /**
     * Deletes the collection of domain entities.
     *
     * @param entities Particular domain entity collection to be deleted
     */
    void delete(Collection<T> entities);

    /**
     * Updates the domain entities.
     *
     * @param entity Particular domain entity to be updated
     * @return Optional wrapper that may have or not content depending on entity validness
     */
    Optional<T> update(T entity);

    /**
     * Finds the domain entity by entity specification.
     *
     * @param entitySpecification Particular entity specification witch a predicate
     * @return Optional wrapper that may have or not content depending on entity specification validness
     */
    Optional<Collection<T>> findAll(EntitySpecification<T> entitySpecification);

    /**
     * Finds all domain entities in data source by entity specification.
     *
     * @param entitySpecification Particular entity specification witch predicate
     * @return Optional wrapper that may have or not content depending on entity specification validness
     */
    Optional<T> findOne(EntitySpecification<T> entitySpecification);
}
