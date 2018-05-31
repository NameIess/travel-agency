package com.epam.lab.task.agency.repository.specification.impl;

import com.epam.lab.task.agency.entity.Hotel;
import com.epam.lab.task.agency.repository.specification.EntitySpecification;

/**
 * Contains data and conditions to verify incoming hotel entity.
 */
public class HotelSpecificationById implements EntitySpecification<Hotel> {
    private Long id;

    /**
     * Constructor is used to provide an dependencies injection.
     *
     * @param id Particular hotel identifier
     */
    public HotelSpecificationById(Long id) {
        this.id = id;
    }

    @Override
    public boolean specified(Hotel entity) {
        Long entityId = entity.getId();
        return id.equals(entityId);
    }
}
