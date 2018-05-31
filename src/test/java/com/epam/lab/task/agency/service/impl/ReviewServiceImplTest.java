package com.epam.lab.task.agency.service.impl;

import com.epam.lab.task.agency.entity.Review;
import com.epam.lab.task.agency.repository.ReviewRepository;
import com.epam.lab.task.agency.repository.impl.ReviewRepositoryImpl;
import com.epam.lab.task.agency.repository.specification.impl.ReviewSpecificationById;
import com.epam.lab.task.agency.resources.review.ReviewDataProvider;
import com.epam.lab.task.agency.resources.review.ReviewTestResource;
import com.epam.lab.task.agency.service.ReviewService;
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
public class ReviewServiceImplTest extends ReviewDataProvider {
    private ReviewService underTest;
    private ReviewRepository reviewRepository;

    @Before
    public void doSetup() {
        reviewRepository = mock(ReviewRepositoryImpl.class);
        underTest = new ReviewServiceImpl(reviewRepository);
    }

    @Test
    @UseDataProvider("validReviewAndOptional")
    public void shouldReturnReviewWhenSavedReviewIsValid(Review review, Optional<Review> expectedResult) {
        when(reviewRepository.save(any(Review.class))).thenReturn(expectedResult);

        Review actualResult = underTest.save(review);

        verify(reviewRepository, times(1)).save(any(Review.class));
        Assert.assertTrue(expectedResult.isPresent());
        Assert.assertEquals(actualResult, expectedResult.get());
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validReview")
    public void shouldThrowServiceExceptionWhenSavedReviewInvalid(Review review) {
        when(reviewRepository.save(any(Review.class))).thenReturn(ReviewTestResource.EMPTY_OPTIONAL_REVIEW);

        underTest.save(review);
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptionalCollection")
    public void shouldDeleteReviewWhenDeletedReviewIsValid(ReviewSpecificationById specificationById, Optional<Collection<Review>> expectedResult) {
        when(reviewRepository.findAll(any(ReviewSpecificationById.class))).thenReturn(expectedResult);

        underTest.delete(specificationById);

        verify(reviewRepository, times(1)).delete(anyCollectionOf(Review.class));
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validSpecificationById")
    public void shouldThrowServiceExceptionWhenDeletedReviewInvalid(ReviewSpecificationById specificationById) {
        when(reviewRepository.findAll(any(ReviewSpecificationById.class))).thenReturn(ReviewTestResource.EMPTY_OPTIONAL_REVIEW_COLLECTION);

        underTest.delete(specificationById);
    }

    @Test
    @UseDataProvider("validReviewAndOptional")
    public void shouldReturnReviewWhenUpdatedReviewIsValid(Review review, Optional<Review> expectedResult) {
        when(reviewRepository.update(review)).thenReturn(expectedResult);

        Review actualResult = underTest.update(review);

        verify(reviewRepository, times(1)).update(review);
        Assert.assertTrue(expectedResult.isPresent());
        Assert.assertEquals(actualResult, expectedResult.get());
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validReview")
    public void shouldThrowServiceExceptionWhenUpdatedReviewInvalid(Review review) {
        when(reviewRepository.update(review)).thenReturn(ReviewTestResource.EMPTY_OPTIONAL_REVIEW);

        underTest.update(review);
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptional")
    public void shouldReturnReviewWhenFoundedReviewIsValid(ReviewSpecificationById specificationById, Optional<Review> expectedResult) {
        when(reviewRepository.findOne(specificationById)).thenReturn(expectedResult);

        Review actualResult = underTest.findOne(specificationById);

        verify(reviewRepository, times(1)).findOne(specificationById);
        Assert.assertTrue(expectedResult.isPresent());
        Assert.assertEquals(actualResult, expectedResult.get());
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validSpecificationById")
    public void shouldThrowServiceExceptionWhenFoundedReviewInvalid(ReviewSpecificationById specificationById) {
        when(reviewRepository.findOne(any(ReviewSpecificationById.class))).thenReturn(ReviewTestResource.EMPTY_OPTIONAL_REVIEW);

        underTest.findOne(specificationById);
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptionalCollection")
    public void shouldReturnReviewCollectionWhenFoundedCollectionIsValid(ReviewSpecificationById specificationById, Optional<Collection<Review>> expectedResult) {
        when(reviewRepository.findAll(specificationById)).thenReturn(expectedResult);

        Collection<Review> actualResult = underTest.findAll(specificationById);

        verify(reviewRepository, times(1)).findAll(specificationById);
        Assert.assertTrue(expectedResult.isPresent());
        Assert.assertEquals(actualResult, expectedResult.get());
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validSpecificationById")
    public void shouldThrowServiceExceptionWhenFoundedCollectionInvalid(ReviewSpecificationById specificationById) {
        when(reviewRepository.findAll(any(ReviewSpecificationById.class))).thenReturn(ReviewTestResource.EMPTY_OPTIONAL_REVIEW_COLLECTION);

        underTest.findAll(specificationById);
    }
}
