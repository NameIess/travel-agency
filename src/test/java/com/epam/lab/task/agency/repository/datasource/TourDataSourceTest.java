package com.epam.lab.task.agency.repository.datasource;

import com.epam.lab.task.agency.entity.Tour;
import com.epam.lab.task.agency.resources.tour.TourDataProvider;
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
public class TourDataSourceTest extends TourDataProvider {
    private GenericDataSource<Tour, Long> underTest;
    private Collection<Tour> tourCollection;

    @Before
    public void doSetup() {
        underTest = TourDataSource.getInstance();
        tourCollection = mock(ArrayList.class);
        underTest.setDataSource(tourCollection);
    }

    @Test
    @UseDataProvider("validTourCollection")
    public void shouldDeleteTourWhenDeletedTourIsValid(Collection<Tour> tours) {
        underTest.delete(tours);

        verify(tourCollection, times(1)).removeAll(anyCollectionOf(Tour.class));
    }

    @Test
    @UseDataProvider("validTourAndOptional")
    public void shouldUpdateTourWhenUpdatedTourIsValid(Tour tour, Optional<Tour> expectedResult) {
        when(tourCollection.removeIf(any(Predicate.class))).thenReturn(true);

        Optional<Tour> actualResult = underTest.update(tour);

        verify(tourCollection, times(1)).add(any(Tour.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @UseDataProvider("validTourEmptyOptional")
    public void shouldUpdateTourWhenUpdatedTourInvalid(Tour tour, Optional<Tour> expectedResult) {
        when(tourCollection.removeIf(any(Predicate.class))).thenReturn(false);

        Optional<Tour> actualResult = underTest.update(tour);

        verify(tourCollection, times(0)).add(any(Tour.class));
        Assert.assertEquals(actualResult, expectedResult);
    }
}
