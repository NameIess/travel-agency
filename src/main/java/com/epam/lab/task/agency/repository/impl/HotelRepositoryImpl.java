package com.epam.lab.task.agency.repository.impl;

import com.epam.lab.task.agency.entity.Hotel;
import com.epam.lab.task.agency.repository.HotelRepository;
import com.epam.lab.task.agency.repository.datasource.GenericDataSource;

/**
 * Contains the particular data source and provides interaction with it.
 */
public class HotelRepositoryImpl implements HotelRepository {
    private GenericDataSource<Hotel, Long> dataSource;

    /**
     * Constructor is used to provide an dependencies injection.
     *
     * @param dataSource Particular {@link GenericDataSource} implementation
     */
    public HotelRepositoryImpl(GenericDataSource<Hotel, Long> dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public GenericDataSource<Hotel, Long> getDataSource() {
        return dataSource;
    }
}
