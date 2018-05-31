package com.epam.lab.task.agency.repository.specification.impl;

import com.epam.lab.task.agency.entity.Review;
import com.epam.lab.task.agency.repository.specification.EntitySpecification;

import java.util.Set;

/**
 * Contains data and conditions to verify incoming review entity.
 */
public class ReviewSpecificationAllByIdIn implements EntitySpecification<Review> {
    private Set<Long> identifiers;

    /**
     * Constructor is used to provide an dependencies injection.
     *
     * @param identifiers set of review identifiers
     */
    public ReviewSpecificationAllByIdIn(Set<Long> identifiers) {
        this.identifiers = identifiers;
    }

    @Override
    public boolean specified(Review entity) {
        Long entityId = entity.getId();
        return identifiers.contains(entityId);
    }
}
