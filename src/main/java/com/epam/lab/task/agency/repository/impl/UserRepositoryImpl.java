package com.epam.lab.task.agency.repository.impl;

import com.epam.lab.task.agency.entity.User;
import com.epam.lab.task.agency.repository.UserRepository;
import com.epam.lab.task.agency.repository.datasource.GenericDataSource;

/**
 * Contains the particular data source and provides interaction with it.
 */
public class UserRepositoryImpl implements UserRepository {
    private GenericDataSource<User, Long> dataSource;

    /**
     * Constructor is used to provide an dependencies injection.
     *
     * @param dataSource Particular {@link GenericDataSource} implementation
     */
    public UserRepositoryImpl(GenericDataSource<User, Long> dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public GenericDataSource<User, Long> getDataSource() {
        return dataSource;
    }
}
