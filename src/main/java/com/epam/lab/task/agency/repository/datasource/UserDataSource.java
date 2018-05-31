package com.epam.lab.task.agency.repository.datasource;

import com.epam.lab.task.agency.entity.User;

import java.util.Collection;

/**
 * Singleton class contains user domain entity data source and provides basic operations.
 */
public enum UserDataSource implements GenericDataSource<User, Long> {
    INSTANCE;

    private Collection<User> users;

    public static UserDataSource getInstance() {
        return INSTANCE;
    }

    @Override
    public Collection<User> getDataSource() {
        return users;
    }

    @Override
    public void setDataSource(Collection<User> collection) {
        this.users = collection;
    }

    @Override
    public String toString() {
        return "UserDataSource{" +
                "users=" + users +
                '}';
    }
}
