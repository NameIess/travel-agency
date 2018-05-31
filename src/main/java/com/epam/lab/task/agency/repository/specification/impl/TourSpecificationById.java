package com.epam.lab.task.agency.repository.specification.impl;

import com.epam.lab.task.agency.entity.Tour;
import com.epam.lab.task.agency.repository.specification.EntitySpecification;

/**
 * Contains data and conditions to verify incoming tour entity.
 */
public class TourSpecificationById implements EntitySpecification<Tour> {
    private Long id;

    /**
     * Constructor is used to provide an dependencies injection.
     *
     * @param id Particular tour identifier
     */
    public TourSpecificationById(Long id) {
        this.id = id;
    }

    @Override
    public boolean specified(Tour entity) {
        Long entityId = entity.getId();
        return id.equals(entityId);
    }
}
