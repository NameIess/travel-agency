package com.epam.lab.task.agency.repository.impl;

import com.epam.lab.task.agency.entity.Tour;
import com.epam.lab.task.agency.repository.TourRepository;
import com.epam.lab.task.agency.repository.datasource.GenericDataSource;

/**
 * Contains the particular data source and provides interaction with it.
 */
public class TourRepositoryImpl implements TourRepository {
    private GenericDataSource<Tour, Long> dataSource;

    /**
     * Constructor is used to provide an dependencies injection.
     *
     * @param dataSource Particular {@link GenericDataSource} implementation
     */
    public TourRepositoryImpl(GenericDataSource<Tour, Long> dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public GenericDataSource<Tour, Long> getDataSource() {
        return dataSource;
    }
}
