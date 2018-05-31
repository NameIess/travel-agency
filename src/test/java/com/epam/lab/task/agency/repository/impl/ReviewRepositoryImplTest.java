package com.epam.lab.task.agency.repository.impl;

import com.epam.lab.task.agency.entity.Review;
import com.epam.lab.task.agency.repository.ReviewRepository;
import com.epam.lab.task.agency.repository.datasource.GenericDataSource;
import com.epam.lab.task.agency.repository.specification.impl.ReviewSpecificationById;
import com.epam.lab.task.agency.resources.review.ReviewDataProvider;
import com.epam.lab.task.agency.resources.review.ReviewTestResource;
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
public class ReviewRepositoryImplTest extends ReviewDataProvider {
    private GenericDataSource<Review, Long> dataSource;
    private ReviewRepository underTest;
    private Collection<Review> reviewCollection;

    @Before
    public void doSetup() {
        dataSource = mock(GenericDataSource.class);
        underTest = new ReviewRepositoryImpl(dataSource);
        reviewCollection = mock(Collection.class);
    }

    @Test
    @UseDataProvider("validReviewAndOptional")
    public void shouldReturnOptionalReviewWhenSavedReviewIsValid(Review review, Optional<Review> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(reviewCollection);
        when(dataSource.insert(any(Review.class))).thenReturn(expectedResult);

        Optional<Review> actualValue = underTest.save(review);

        verify(dataSource, times(1)).insert(any(Review.class));
        Assert.assertEquals(actualValue, expectedResult);
    }

    @Test
    @UseDataProvider("validReviewEmptyOptional")
    public void shouldReturnOptionalReviewWhenSavedReviewInvalid(Review review, Optional<Review> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(reviewCollection);
        when(dataSource.insert(any(Review.class))).thenReturn(expectedResult);

        Optional<Review> actualResult = underTest.save(review);

        verify(dataSource, times(1)).insert(any(Review.class));
        Assert.assertFalse(expectedResult.isPresent());
        Assert.assertFalse(actualResult.isPresent());
    }

    @Test
    @UseDataProvider("validReview")
    public void shouldDeleteReviewWhenDeletedReviewIsValid(Review review) {
        when(dataSource.getDataSource()).thenReturn(reviewCollection);

        underTest.delete(review);

        verify(dataSource, times(1)).delete(any(Review.class));
    }

    @Test
    @UseDataProvider("validReviewAndOptional")
    public void shouldUpdateReviewWhenUpdatedReviewIsValid(Review review, Optional<Review> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(reviewCollection);
        when(dataSource.update(any(Review.class))).thenReturn(expectedResult);

        Optional<Review> actualResult = underTest.update(review);

        verify(dataSource, times(1)).update(any(Review.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptionalCollection")
    public void shouldReturnReviewCollectionWhenSpecificationSatisfies(ReviewSpecificationById specificationById, Optional<Collection<Review>> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(reviewCollection);
        when(dataSource.findAllByCriteria(any(ReviewSpecificationById.class))).thenReturn(expectedResult);

        Optional<Collection<Review>> actualResult = underTest.findAll(specificationById);

        verify(dataSource, times(1)).findAllByCriteria(any(ReviewSpecificationById.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @UseDataProvider("invalidSpecificationById")
    public void shouldReturnReviewCollectionWhenSpecificationNotSatisfies(ReviewSpecificationById specificationById) {
        when(dataSource.getDataSource()).thenReturn(reviewCollection);
        when(dataSource.findAllByCriteria(any(ReviewSpecificationById.class))).thenReturn(ReviewTestResource.EMPTY_OPTIONAL_REVIEW_COLLECTION);

        Optional<Collection<Review>> actualResult = underTest.findAll(specificationById);

        verify(dataSource, times(1)).findAllByCriteria(any(ReviewSpecificationById.class));
        Assert.assertFalse(actualResult.isPresent());
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptional")
    public void shouldReturnReviewWhenSpecificationSatisfies(ReviewSpecificationById specificationById, Optional<Review> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(reviewCollection);
        when(dataSource.findOneByCriteria(any(ReviewSpecificationById.class))).thenReturn(expectedResult);

        Optional<Review> actualResult = underTest.findOne(specificationById);

        verify(dataSource, times(1)).findOneByCriteria(any(ReviewSpecificationById.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @UseDataProvider("invalidSpecificationById")
    public void shouldReturnReviewWhenSpecificationNotSatisfies(ReviewSpecificationById specificationById) {
        when(dataSource.getDataSource()).thenReturn(reviewCollection);
        when(dataSource.findOneByCriteria(any(ReviewSpecificationById.class))).thenReturn(ReviewTestResource.EMPTY_OPTIONAL_REVIEW);

        Optional<Review> actualResult = underTest.findOne(specificationById);

        verify(dataSource, times(1)).findOneByCriteria(any(ReviewSpecificationById.class));
        Assert.assertFalse(actualResult.isPresent());
    }
}
