package com.epam.lab.task.agency.repository.impl;

import com.epam.lab.task.agency.entity.Country;
import com.epam.lab.task.agency.repository.CountryRepository;
import com.epam.lab.task.agency.repository.datasource.GenericDataSource;

/**
 * Contains the particular data source and provides interaction with it.
 */
public class CountryRepositoryImpl implements CountryRepository {
    private GenericDataSource<Country, Long> dataSource;

    /**
     * Constructor is used to provide an dependencies injection.
     *
     * @param dataSource Particular {@link GenericDataSource} implementation
     */
    public CountryRepositoryImpl(GenericDataSource<Country, Long> dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public GenericDataSource<Country, Long> getDataSource() {
        return dataSource;
    }
}
