package com.epam.lab.task.agency.repository.specification;

/**
 * Specification for the particular domain entity to check its suitability.
 *
 * @param <T> Particular domain entity type
 */
public interface EntitySpecification<T> {
    /**
     * Predicate to be used to handle incoming data.
     *
     * @param entity Object to be checked
     * @return Result of the entity suitability
     */
    boolean specified(T entity);
}
