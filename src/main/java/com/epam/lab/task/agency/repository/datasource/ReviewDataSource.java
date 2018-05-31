package com.epam.lab.task.agency.repository.datasource;

import com.epam.lab.task.agency.entity.Review;

import java.util.Collection;

/**
 * Singleton class contains review domain entity data source and provides basic operations.
 */
public enum ReviewDataSource implements GenericDataSource<Review, Long> {
    INSTANCE;

    private Collection<Review> reviews;

    public static ReviewDataSource getInstance() {
        return INSTANCE;
    }

    @Override
    public Collection<Review> getDataSource() {
        return reviews;
    }

    @Override
    public void setDataSource(Collection<Review> collection) {
        this.reviews = collection;
    }

    @Override
    public String toString() {
        return "ReviewDataSource{" +
                "reviews=" + reviews +
                '}';
    }
}
