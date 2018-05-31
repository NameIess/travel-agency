package com.epam.lab.task.agency.entity;

import java.io.Serializable;

/**
 * Used to identify domain entities.
 *
 * @param <T> Particular ID type the entity is identified by
 */
public interface Identified<T> extends Serializable {
    /**
     * Returns the T typed id value the entity is identified by.
     *
     * @return Particular entity identifier
     */
    T getId();
}
