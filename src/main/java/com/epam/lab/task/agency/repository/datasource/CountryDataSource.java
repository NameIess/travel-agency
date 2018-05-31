package com.epam.lab.task.agency.repository.datasource;

import com.epam.lab.task.agency.entity.Country;

import java.util.Collection;

/**
 * Singleton class contains country domain entity data source and provides basic operations.
 */
public enum CountryDataSource implements GenericDataSource<Country, Long> {
    INSTANCE;

    private Collection<Country> countries;

    public static CountryDataSource getInstance() {
        return INSTANCE;
    }

    @Override
    public Collection<Country> getDataSource() {
        return countries;
    }

    @Override
    public void setDataSource(Collection<Country> collection) {
        this.countries = collection;
    }

    @Override
    public String toString() {
        return "CountryDataSource{" +
                "countries=" + countries +
                '}';
    }
}
