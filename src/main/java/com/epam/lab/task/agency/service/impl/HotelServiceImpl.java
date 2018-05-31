package com.epam.lab.task.agency.service.impl;

import com.epam.lab.task.agency.entity.Hotel;
import com.epam.lab.task.agency.repository.HotelRepository;
import com.epam.lab.task.agency.repository.specification.EntitySpecification;
import com.epam.lab.task.agency.service.HotelService;
import com.epam.lab.task.agency.service.exception.ServiceException;

import java.util.Collection;
import java.util.Optional;

/**
 * Contains basic operations implementation to interact with hotel.
 */
public class HotelServiceImpl implements HotelService {
    private HotelRepository hotelRepository;

    /**
     * Constructor is used to provide an dependencies injection.
     *
     * @param hotelRepository Particular HotelRepository implementation
     */
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel save(Hotel hotel) {
        Optional<Hotel> hotelOptional = hotelRepository.save(hotel);
        return hotelOptional.orElseThrow(
                () -> new ServiceException("Trouble within save(): optional values is null")
        );
    }

    @Override
    public void delete(EntitySpecification<Hotel> entitySpecification) {
        Collection<Hotel> hotels = findAll(entitySpecification);
        hotelRepository.delete(hotels);
    }

    @Override
    public Hotel update(Hotel hotel) {
        Optional<Hotel> hotelOptional = hotelRepository.update(hotel);
        return hotelOptional.orElseThrow(
                () -> new ServiceException("Trouble within update(): optional values is null")
        );
    }

    @Override
    public Hotel findOne(EntitySpecification<Hotel> entitySpecification) {
        Optional<Hotel> hotelOptional = hotelRepository.findOne(entitySpecification);
        return hotelOptional.orElseThrow(
                () -> new ServiceException("Trouble within findOne(): optional values is null")
        );
    }

    @Override
    public Collection<Hotel> findAll(EntitySpecification<Hotel> entitySpecification) {
        Optional<Collection<Hotel>> hotelsOptional = hotelRepository.findAll(entitySpecification);
        return hotelsOptional.orElseThrow(
                () -> new ServiceException("Trouble within findAll(): optional values is null")
        );
    }
}
