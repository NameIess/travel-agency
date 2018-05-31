package com.epam.lab.task.agency.repository.datasource;

import com.epam.lab.task.agency.entity.Hotel;

import java.util.Collection;

/**
 * Singleton class contains hotel domain entity data source and provides basic operations.
 */
public enum HotelDataSource implements GenericDataSource<Hotel, Long> {
    INSTANCE;

    private Collection<Hotel> hotels;

    public static HotelDataSource getInstance() {
        return INSTANCE;
    }

    @Override
    public Collection<Hotel> getDataSource() {
        return hotels;
    }

    @Override
    public void setDataSource(Collection<Hotel> collection) {
        this.hotels = collection;
    }

    @Override
    public String toString() {
        return "HotelDataSource{" +
                "hotels=" + hotels +
                '}';
    }
}
