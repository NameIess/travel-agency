package com.epam.lab.task.agency.repository.datasource;

import com.epam.lab.task.agency.entity.Review;
import com.epam.lab.task.agency.resources.review.ReviewDataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(DataProviderRunner.class)
public class ReviewDataSourceTest extends ReviewDataProvider {
    private GenericDataSource<Review, Long> underTest;
    private Collection<Review> reviewCollection;

    @Before
    public void doSetup() {
        underTest = ReviewDataSource.getInstance();
        reviewCollection = mock(ArrayList.class);
        underTest.setDataSource(reviewCollection);
    }

    @Test
    @UseDataProvider("validReviewCollection")
    public void shouldDeleteReviewCollectionWhenDeletedReviewIsValid(Collection<Review> reviews) {
        underTest.delete(reviews);

        verify(reviewCollection, times(1)).removeAll(anyCollectionOf(Review.class));
    }

    @Test
    @UseDataProvider("validReviewAndOptional")
    public void shouldUpdateReviewWhenUpdatedReviewIsValid(Review review, Optional<Review> expectedResult) {
        when(reviewCollection.removeIf(any(Predicate.class))).thenReturn(true);

        Optional<Review> actualResult = underTest.update(review);

        verify(reviewCollection, times(1)).add(any(Review.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @UseDataProvider("validReviewEmptyOptional")
    public void shouldUpdateReviewWhenUpdatedReviewInvalid(Review review, Optional<Review> expectedResult) {
        when(reviewCollection.removeIf(any(Predicate.class))).thenReturn(false);

        Optional<Review> actualResult = underTest.update(review);

        verify(reviewCollection, times(0)).add(any(Review.class));
        Assert.assertEquals(actualResult, expectedResult);
    }
}
