package com.epam.lab.task.agency.repository.datasource;

import com.epam.lab.task.agency.entity.Tour;

import java.util.Collection;

/**
 * Singleton class contains tour domain entity data source and provides basic operations.
 */
public enum TourDataSource implements GenericDataSource<Tour, Long> {
    INSTANCE;

    private Collection<Tour> tours;

    public static TourDataSource getInstance() {
        return INSTANCE;
    }

    @Override
    public Collection<Tour> getDataSource() {
        return tours;
    }

    @Override
    public void setDataSource(Collection<Tour> collection) {
        this.tours = collection;
    }

    @Override
    public String toString() {
        return "TourDataSource{" +
                "tours=" + tours +
                '}';
    }
}
