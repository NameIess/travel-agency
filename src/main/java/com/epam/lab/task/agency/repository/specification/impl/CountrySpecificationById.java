package com.epam.lab.task.agency.repository.specification.impl;

import com.epam.lab.task.agency.entity.Country;
import com.epam.lab.task.agency.repository.specification.EntitySpecification;

/**
 * Contains data and conditions to verify incoming country entity.
 */
public class CountrySpecificationById implements EntitySpecification<Country> {
    private Long id;

    /**
     * Constructor is used to provide an dependencies injection.
     *
     * @param id Particular country identifier
     */
    public CountrySpecificationById(Long id) {
        this.id = id;
    }

    @Override
    public boolean specified(Country entity) {
        Long entityId = entity.getId();
        return id.equals(entityId);
    }
}
