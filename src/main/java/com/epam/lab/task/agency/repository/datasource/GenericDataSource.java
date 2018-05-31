package com.epam.lab.task.agency.repository.datasource;

import com.epam.lab.task.agency.entity.Identified;
import com.epam.lab.task.agency.repository.specification.EntitySpecification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Contains basic operations of interaction with domain entities data source and provides generic implementation.
 *
 * @param <T> Domain entity type
 * @param <V> Domain entity identifier type
 */
public interface GenericDataSource<T extends Identified<V>, V> {
    ReadWriteLock READ_WRITE_LOCK = new ReentrantReadWriteLock();
    Lock READ_LOCK = READ_WRITE_LOCK.readLock();
    Lock WRITE_LOCK = READ_WRITE_LOCK.writeLock();

    /**
     * Receiver of data source.
     *
     * @return Particular domain entity data source
     */
    Collection<T> getDataSource();

    /**
     * Setter for data source.
     *
     * @param collection Particular domain entity data source
     */
    void setDataSource(Collection<T> collection);

    /**
     * Inserts domain entity to data source.
     *
     * @param entity Particular domain entity to be inserted
     * @return Optional wrapper that may have or not content depending on entity validness
     */
    default Optional<T> insert(T entity) {
        try {
            WRITE_LOCK.lock();

            Collection<T> dataSource = getDataSource();
            Optional<T> entityOptional = Optional.empty();

            Optional<T> savedEntity = dataSource
                    .stream()
                    .filter(item -> entity.getId().equals(item.getId()))
                    .findFirst();

            if (!savedEntity.isPresent()) {
                dataSource.add(entity);
                entityOptional = Optional.of(entity);
            }

            return entityOptional;

        } finally {
            WRITE_LOCK.unlock();
        }
    }

    /**
     * Deletes domain entity from data source.
     *
     * @param entity Particular domain entity to be deleted
     */
    default void delete(T entity) {
        try {
            WRITE_LOCK.lock();

            Collection<T> dataSource = getDataSource();
            dataSource.remove(entity);

        } finally {
            WRITE_LOCK.unlock();
        }
    }

    /**
     * Deleted collection of domain entities from data source.
     *
     * @param entities Particular domain entity collection to be deleted
     */
    default void delete(Collection<T> entities) {
        try {
            WRITE_LOCK.lock();

            Collection<T> dataSource = getDataSource();
            dataSource.removeAll(entities);

        } finally {
            WRITE_LOCK.unlock();
        }
    }

    /**
     * Updates domain entity in data source.
     *
     * @param entity Particular domain entity to be updated
     * @return Optional wrapper that may have or not content depending on entity validness
     */
    default Optional<T> update(T entity) {
        try {
            WRITE_LOCK.lock();

            Collection<T> dataSource = getDataSource();
            V entityV = entity.getId();
            Optional<T> entityOptional = Optional.empty();

            if (dataSource.removeIf(item -> entityV.equals(item.getId()))) {
                dataSource.add(entity);
                entityOptional = Optional.of(entity);
            }
            return entityOptional;

        } finally {
            WRITE_LOCK.unlock();
        }
    }

    /**
     * Finds domain entity in data source by entity specification.
     *
     * @param entitySpecification Particular entity specification witch predicate
     * @return Optional wrapper that may have or not content depending on entity specification validness
     */
    default Optional<T> findOneByCriteria(EntitySpecification<T> entitySpecification) {
        try {
            READ_LOCK.lock();

            Collection<T> dataSource = getDataSource();

            return dataSource
                    .stream()
                    .filter(entitySpecification::specified)
                    .findFirst();

        } finally {
            READ_LOCK.unlock();
        }
    }

    /**
     * Finds all domain entities in data source by entity specification.
     *
     * @param entitySpecification Particular entity specification witch predicate
     * @return Optional wrapper that may have or not content depending on entity specification validness
     */
    default Optional<Collection<T>> findAllByCriteria(EntitySpecification<T> entitySpecification) {
        try {
            READ_LOCK.lock();

            Collection<T> dataSource = getDataSource();
            Collection<T> entities = new ArrayList<>();
            dataSource.forEach(item -> {
                if (entitySpecification.specified(item)) {
                    entities.add(item);
                }
            });
            return entities.isEmpty() ? Optional.empty() : Optional.of(entities);

        } finally {
            READ_LOCK.unlock();
        }
    }
}
