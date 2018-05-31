package com.epam.lab.task.agency.repository.specification.impl;

import com.epam.lab.task.agency.entity.User;
import com.epam.lab.task.agency.repository.specification.EntitySpecification;

/**
 * Contains data and conditions to verify incoming user entity.
 */
public class UserSpecificationById implements EntitySpecification<User> {
    private Long id;

    /**
     * Constructor is used to provide an dependencies injection.
     *
     * @param id Particular user identifier
     */
    public UserSpecificationById(Long id) {
        this.id = id;
    }

    @Override
    public boolean specified(User entity) {
        Long entityId = entity.getId();
        return id.equals(entityId);
    }
}
