package com.epam.lab.task.agency.repository.specification.impl;

import com.epam.lab.task.agency.entity.Review;
import com.epam.lab.task.agency.repository.specification.EntitySpecification;

/**
 * Contains data and conditions to verify incoming review entity.
 */
public class ReviewSpecificationById implements EntitySpecification<Review> {
    private Long id;

    /**
     * Constructor is used to provide an dependencies injection.
     *
     * @param id Particular review identifier
     */
    public ReviewSpecificationById(Long id) {
        this.id = id;
    }

    @Override
    public boolean specified(Review entity) {
        Long entityId = entity.getId();
        return id.equals(entityId);
    }
}
