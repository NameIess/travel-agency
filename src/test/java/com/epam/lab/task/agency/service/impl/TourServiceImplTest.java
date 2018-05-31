package com.epam.lab.task.agency.service.impl;

import com.epam.lab.task.agency.entity.Tour;
import com.epam.lab.task.agency.repository.TourRepository;
import com.epam.lab.task.agency.repository.specification.impl.ReviewSpecificationAllByIdIn;
import com.epam.lab.task.agency.repository.specification.impl.TourSpecificationById;
import com.epam.lab.task.agency.resources.tour.TourDataProvider;
import com.epam.lab.task.agency.resources.tour.TourTestResource;
import com.epam.lab.task.agency.service.ReviewService;
import com.epam.lab.task.agency.service.TourService;
import com.epam.lab.task.agency.service.exception.ServiceException;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collection;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(DataProviderRunner.class)
public class TourServiceImplTest extends TourDataProvider {
    private TourService underTest;
    private TourRepository tourRepository;
    private ReviewService reviewService;

    @Before
    public void doSetup() {
        tourRepository = mock(TourRepository.class);
        reviewService = mock(ReviewService.class);
        underTest = new TourServiceImpl(tourRepository, reviewService);
    }

    @Test
    @UseDataProvider("validTourAndOptional")
    public void shouldReturnTourWhenSavedTourIsValid(Tour tour, Optional<Tour> expectedResult) {
        when(tourRepository.save(any(Tour.class))).thenReturn(expectedResult);

        Tour actualResult = underTest.save(tour);

        verify(tourRepository, times(1)).save(any(Tour.class));
        Assert.assertTrue(expectedResult.isPresent());
        Assert.assertEquals(actualResult, expectedResult.get());
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validTour")
    public void shouldThrowServiceExceptionWhenSavedTourInvalid(Tour tour) {
        when(tourRepository.save(tour)).thenReturn(TourTestResource.EMPTY_OPTIONAL_TOUR);

        underTest.save(tour);
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptionalCollection")
    public void shouldDeleteTourWhenDeletedTourIsValid(TourSpecificationById specificationById, Optional<Collection<Tour>> expectedResult) {
        when(tourRepository.findAll(any(TourSpecificationById.class))).thenReturn(expectedResult);

        underTest.delete(specificationById);

        verify(reviewService, times(1)).delete(any(ReviewSpecificationAllByIdIn.class));
        verify(tourRepository, times(1)).delete(anyCollectionOf(Tour.class));
    }

    @Test
    @UseDataProvider("validTourAndOptional")
    public void shouldReturnTourWhenUpdatedTourIsValid(Tour tour, Optional<Tour> expectedResult) {
        when(tourRepository.update(any(Tour.class))).thenReturn(expectedResult);

        Tour actualResult = underTest.update(tour);

        verify(tourRepository, times(1)).update(any(Tour.class));
        Assert.assertTrue(expectedResult.isPresent());
        Assert.assertEquals(actualResult, expectedResult.get());
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validTour")
    public void shouldThrowServiceExceptionWhenUpdatedTourInvalid(Tour tour) {
        when(tourRepository.update(any(Tour.class))).thenReturn(TourTestResource.EMPTY_OPTIONAL_TOUR);

        underTest.update(tour);
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptional")
    public void shouldReturnTourWhenFoundedTourIsValid(TourSpecificationById specificationById, Optional<Tour> expectedResult) {
        when(tourRepository.findOne(any(TourSpecificationById.class))).thenReturn(expectedResult);

        Tour actualResult = underTest.findOne(specificationById);

        verify(tourRepository, times(1)).findOne(any(TourSpecificationById.class));
        Assert.assertTrue(expectedResult.isPresent());
        Assert.assertEquals(actualResult, expectedResult.get());
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validSpecificationById")
    public void shouldThrowServiceExceptionWhenFoundedTourInvalid(TourSpecificationById specificationById) {
        when(tourRepository.findOne(any(TourSpecificationById.class))).thenReturn(TourTestResource.EMPTY_OPTIONAL_TOUR);

        underTest.findOne(specificationById);
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptionalCollection")
    public void shouldReturnTourCollectionWhenFoundedCollectionIsValid(TourSpecificationById specificationById, Optional<Collection<Tour>> expectedResult) {
        when(tourRepository.findAll(any(TourSpecificationById.class))).thenReturn(expectedResult);

        Collection<Tour> actualResult = underTest.findAll(specificationById);

        verify(tourRepository, times(1)).findAll(any(TourSpecificationById.class));
        Assert.assertTrue(expectedResult.isPresent());
        Assert.assertEquals(actualResult, expectedResult.get());
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validSpecificationById")
    public void shouldThrowServiceExceptionWhenFoundedCollectionInvalid(TourSpecificationById specificationById) {
        when(tourRepository.findAll(any(TourSpecificationById.class))).thenReturn(TourTestResource.EMPTY_OPTIONAL_TOUR_COLLECTION);

        underTest.findAll(specificationById);
    }
}
