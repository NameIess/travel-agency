package com.epam.lab.task.agency.repository.generic;

import com.epam.lab.task.agency.entity.Identified;
import com.epam.lab.task.agency.repository.datasource.GenericDataSource;
import com.epam.lab.task.agency.repository.specification.EntitySpecification;

import java.util.Collection;
import java.util.Optional;

/**
 * Contains basic operations implementations for interaction with generic domain entity.
 *
 * @param <T> Particular domain entity type
 * @param <V> Particular V type the entity is identified by
 */
public interface PersistentRepository<T extends Identified<V>, V> extends GenericRepository<T> {
    GenericDataSource<T, V> getDataSource();

    @Override
    default Optional<T> save(T entity) {
        GenericDataSource<T, V> dataSource = getDataSource();
        return dataSource.insert(entity);
    }

    @Override
    default void delete(T entity) {
        GenericDataSource<T, V> dataSource = getDataSource();
        dataSource.delete(entity);
    }

    @Override
    default void delete(Collection<T> entities) {
        GenericDataSource<T, V> dataSource = getDataSource();
        dataSource.delete(entities);
    }

    @Override
    default Optional<T> update(T entity) {
        GenericDataSource<T, V> dataSource = getDataSource();
        return dataSource.update(entity);
    }

    @Override
    default Optional<Collection<T>> findAll(EntitySpecification<T> entitySpecification) {
        GenericDataSource<T, V> dataSource = getDataSource();
        return dataSource.findAllByCriteria(entitySpecification);
    }

    @Override
    default Optional<T> findOne(EntitySpecification<T> entitySpecification) {
        GenericDataSource<T, V> dataSource = getDataSource();
        return dataSource.findOneByCriteria(entitySpecification);
    }
}
