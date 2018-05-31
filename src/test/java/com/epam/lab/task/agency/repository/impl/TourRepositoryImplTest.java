package com.epam.lab.task.agency.repository.impl;

import com.epam.lab.task.agency.entity.Tour;
import com.epam.lab.task.agency.repository.TourRepository;
import com.epam.lab.task.agency.repository.datasource.GenericDataSource;
import com.epam.lab.task.agency.repository.specification.impl.TourSpecificationById;
import com.epam.lab.task.agency.resources.tour.TourDataProvider;
import com.epam.lab.task.agency.resources.tour.TourTestResource;
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
public class TourRepositoryImplTest extends TourDataProvider {
    private GenericDataSource<Tour, Long> dataSource;
    private TourRepository underTest;
    private Collection<Tour> tourCollection;

    @Before
    public void doSetup() {
        dataSource = mock(GenericDataSource.class);
        underTest = new TourRepositoryImpl(dataSource);
        tourCollection = mock(Collection.class);
    }

    @Test
    @UseDataProvider("validTourAndOptional")
    public void shouldReturnOptionalTourWhenSavedTourIsValid(Tour tour, Optional<Tour> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(tourCollection);
        when(dataSource.insert(any(Tour.class))).thenReturn(expectedResult);

        Optional<Tour> actualValue = underTest.save(tour);

        verify(dataSource, times(1)).insert(any(Tour.class));
        Assert.assertEquals(actualValue, expectedResult);
    }

    @Test
    @UseDataProvider("validTourEmptyOptional")
    public void shouldReturnOptionalTourWhenSavedTourInvalid(Tour tour, Optional<Tour> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(tourCollection);
        when(dataSource.insert(any(Tour.class))).thenReturn(expectedResult);

        Optional<Tour> actualResult = underTest.save(tour);

        verify(dataSource, times(1)).insert(any(Tour.class));
        Assert.assertFalse(expectedResult.isPresent());
        Assert.assertFalse(actualResult.isPresent());
    }

    @Test
    @UseDataProvider("validTour")
    public void shouldDeleteTourWhenDeletedTourIsValid(Tour tour) {
        when(dataSource.getDataSource()).thenReturn(tourCollection);

        underTest.delete(tour);

        verify(dataSource, times(1)).delete(any(Tour.class));
    }

    @Test
    @UseDataProvider("validTourAndOptional")
    public void shouldUpdateTourWhenUpdatedTourIsValid(Tour tour, Optional<Tour> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(tourCollection);
        when(dataSource.update(any(Tour.class))).thenReturn(expectedResult);

        Optional<Tour> actualResult = underTest.update(tour);

        verify(dataSource, times(1)).update(any(Tour.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptionalCollection")
    public void shouldReturnTourCollectionWhenSpecificationSatisfies(TourSpecificationById specificationById, Optional<Collection<Tour>> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(tourCollection);
        when(dataSource.findAllByCriteria(any(TourSpecificationById.class))).thenReturn(expectedResult);

        Optional<Collection<Tour>> actualResult = underTest.findAll(specificationById);

        verify(dataSource, times(1)).findAllByCriteria(any(TourSpecificationById.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @UseDataProvider("invalidSpecificationById")
    public void shouldReturnTourCollectionWhenSpecificationNotSatisfies(TourSpecificationById specificationById) {
        when(dataSource.getDataSource()).thenReturn(tourCollection);
        when(dataSource.findAllByCriteria(any(TourSpecificationById.class))).thenReturn(TourTestResource.EMPTY_OPTIONAL_TOUR_COLLECTION);

        Optional<Collection<Tour>> actualResult = underTest.findAll(specificationById);

        verify(dataSource, times(1)).findAllByCriteria(any(TourSpecificationById.class));
        Assert.assertFalse(actualResult.isPresent());
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptional")
    public void shouldReturnTourWhenSpecificationSatisfies(TourSpecificationById specificationById, Optional<Tour> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(tourCollection);
        when(dataSource.findOneByCriteria(any(TourSpecificationById.class))).thenReturn(expectedResult);

        Optional<Tour> actualResult = underTest.findOne(specificationById);

        verify(dataSource, times(1)).findOneByCriteria(any(TourSpecificationById.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @UseDataProvider("invalidSpecificationById")
    public void shouldReturnTourWhenSpecificationNotSatisfies(TourSpecificationById specificationById) {
        when(dataSource.getDataSource()).thenReturn(tourCollection);
        when(dataSource.findOneByCriteria(any(TourSpecificationById.class))).thenReturn(TourTestResource.EMPTY_OPTIONAL_TOUR);

        Optional<Tour> actualResult = underTest.findOne(specificationById);

        verify(dataSource, times(1)).findOneByCriteria(any(TourSpecificationById.class));
        Assert.assertFalse(actualResult.isPresent());
    }
}
