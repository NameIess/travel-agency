package com.epam.lab.task.agency.service.impl;

import com.epam.lab.task.agency.entity.Review;
import com.epam.lab.task.agency.repository.ReviewRepository;
import com.epam.lab.task.agency.repository.specification.EntitySpecification;
import com.epam.lab.task.agency.service.ReviewService;
import com.epam.lab.task.agency.service.exception.ServiceException;

import java.util.Collection;
import java.util.Optional;

/**
 * Contains basic operations implementation to interact with review.
 */
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;

    /**
     * Constructor is used to provide an dependencies injection.
     *
     * @param reviewRepository Particular ReviewRepository implementation
     */
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review save(Review review) {
        Optional<Review> reviewOptional = reviewRepository.save(review);
        return reviewOptional.orElseThrow(
                () -> new ServiceException("Trouble within save(): optional values is null")
        );
    }

    @Override
    public void delete(EntitySpecification<Review> entitySpecification) {
        Collection<Review> reviews = findAll(entitySpecification);
        reviewRepository.delete(reviews);
    }

    @Override
    public Review update(Review review) {
        Optional<Review> reviewOptional = reviewRepository.update(review);
        return reviewOptional.orElseThrow(
                () -> new ServiceException("Trouble within update(): optional values is null")
        );
    }

    @Override
    public Review findOne(EntitySpecification<Review> entitySpecification) {
        Optional<Review> reviewOptional = reviewRepository.findOne(entitySpecification);
        return reviewOptional.orElseThrow(
                () -> new ServiceException("Trouble within findOne(): optional values is null")
        );
    }

    @Override
    public Collection<Review> findAll(EntitySpecification<Review> entitySpecification) {
        Optional<Collection<Review>> reviewsOptional = reviewRepository.findAll(entitySpecification);
        return reviewsOptional.orElseThrow(
                () -> new ServiceException("Trouble within findAll(): optional values is null")
        );
    }
}
