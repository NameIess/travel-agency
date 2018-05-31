package com.epam.lab.task.agency.service.impl;

import com.epam.lab.task.agency.entity.Tour;
import com.epam.lab.task.agency.repository.TourRepository;
import com.epam.lab.task.agency.repository.specification.EntitySpecification;
import com.epam.lab.task.agency.repository.specification.impl.ReviewSpecificationAllByIdIn;
import com.epam.lab.task.agency.service.ReviewService;
import com.epam.lab.task.agency.service.TourService;
import com.epam.lab.task.agency.service.exception.ServiceException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Contains basic operations implementation to interact with tour.
 */
public class TourServiceImpl implements TourService {
    private TourRepository tourRepository;
    private ReviewService reviewService;

    /**
     * Constructor is used to provide an dependencies injection.
     *
     * @param tourRepository Particular {@link TourRepository} implementation
     * @param reviewService  Particular {@link ReviewService} implementation
     */
    public TourServiceImpl(TourRepository tourRepository, ReviewService reviewService) {
        this.tourRepository = tourRepository;
        this.reviewService = reviewService;
    }

    @Override
    public Tour save(Tour tour) {
        Optional<Tour> tourOptional = tourRepository.save(tour);
        return tourOptional.orElseThrow(
                () -> new ServiceException("Trouble within save(): optional values is null")
        );
    }

    @Override
    public void delete(EntitySpecification<Tour> entitySpecification) {
        Collection<Tour> tours = findAll(entitySpecification);

        Set<Long> reviewsToDelete = new HashSet<>();
        tours.forEach(tour -> tour.getReviews().forEach(review -> reviewsToDelete.add(review.getId())));
        ReviewSpecificationAllByIdIn reviewIdentifiers = new ReviewSpecificationAllByIdIn(reviewsToDelete);
        reviewService.delete(reviewIdentifiers);

        tourRepository.delete(tours);
    }

    @Override
    public Tour update(Tour tour) {
        Optional<Tour> tourOptional = tourRepository.update(tour);
        return tourOptional.orElseThrow(
                () -> new ServiceException("Trouble within update(): optional values is null")
        );
    }

    @Override
    public Tour findOne(EntitySpecification<Tour> entitySpecification) {
        Optional<Tour> tourOptional = tourRepository.findOne(entitySpecification);
        return tourOptional.orElseThrow(
                () -> new ServiceException("Trouble within findOne(): optional values is null")
        );
    }

    @Override
    public Collection<Tour> findAll(EntitySpecification<Tour> entitySpecification) {
        Optional<Collection<Tour>> toursOptional = tourRepository.findAll(entitySpecification);
        return toursOptional.orElseThrow(
                () -> new ServiceException("Trouble within findAll(): optional values is null")
        );
    }
}
