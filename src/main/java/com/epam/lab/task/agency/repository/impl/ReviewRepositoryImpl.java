package com.epam.lab.task.agency.repository.impl;

import com.epam.lab.task.agency.entity.Review;
import com.epam.lab.task.agency.repository.ReviewRepository;
import com.epam.lab.task.agency.repository.datasource.GenericDataSource;

/**
 * Contains the particular data source and provides interaction with it.
 */
public class ReviewRepositoryImpl implements ReviewRepository {
    private GenericDataSource<Review, Long> dataSource;

    /**
     * Constructor is used to provide an dependencies injection.
     *
     * @param dataSource Particular {@link GenericDataSource} implementation
     */
    public ReviewRepositoryImpl(GenericDataSource<Review, Long> dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public GenericDataSource<Review, Long> getDataSource() {
        return dataSource;
    }
}
