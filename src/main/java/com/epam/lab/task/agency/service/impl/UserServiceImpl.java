package com.epam.lab.task.agency.service.impl;

import com.epam.lab.task.agency.entity.User;
import com.epam.lab.task.agency.repository.UserRepository;
import com.epam.lab.task.agency.repository.specification.EntitySpecification;
import com.epam.lab.task.agency.repository.specification.impl.ReviewSpecificationAllByIdIn;
import com.epam.lab.task.agency.service.ReviewService;
import com.epam.lab.task.agency.service.UserService;
import com.epam.lab.task.agency.service.exception.ServiceException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Contains basic operations implementation to interact with user.
 */
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ReviewService reviewService;

    /**
     * Constructor is used to provide an dependencies injection.
     *
     * @param userRepository Particular {@link UserRepository} implementation
     * @param reviewService  Particular {@link ReviewService} implementation
     */
    public UserServiceImpl(UserRepository userRepository, ReviewService reviewService) {
        this.userRepository = userRepository;
        this.reviewService = reviewService;
    }

    @Override
    public User save(User user) {
        Optional<User> userOptional = userRepository.save(user);
        return userOptional.orElseThrow(
                () -> new ServiceException("Trouble within save(): optional values is null")
        );
    }

    @Override
    public void delete(EntitySpecification<User> entitySpecification) {
        Collection<User> users = findAll(entitySpecification);

        Set<Long> reviewsToDelete = new HashSet<>();
        users.forEach(user -> user.getReviews().forEach(review -> reviewsToDelete.add(review.getId())));

        ReviewSpecificationAllByIdIn reviewSpecification = new ReviewSpecificationAllByIdIn(reviewsToDelete);
        reviewService.delete(reviewSpecification);
        userRepository.delete(users);
    }

    @Override
    public User update(User user) {
        Optional<User> userOptional = userRepository.update(user);
        return userOptional.orElseThrow(
                () -> new ServiceException("Trouble within update(): optional values is null")
        );
    }

    @Override
    public User findOne(EntitySpecification<User> entitySpecification) {
        Optional<User> userOptional = userRepository.findOne(entitySpecification);
        return userOptional.orElseThrow(
                () -> new ServiceException("Trouble within findOne(): optional values is null")
        );
    }

    @Override
    public Collection<User> findAll(EntitySpecification<User> entitySpecification) {
        Optional<Collection<User>> usersOptional = userRepository.findAll(entitySpecification);
        return usersOptional.orElseThrow(
                () -> new ServiceException("Trouble within findAll(): optional values is null")
        );
    }
}
