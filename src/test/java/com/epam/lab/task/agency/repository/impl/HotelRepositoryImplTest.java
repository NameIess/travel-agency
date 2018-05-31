package com.epam.lab.task.agency.repository.impl;

import com.epam.lab.task.agency.entity.Hotel;
import com.epam.lab.task.agency.repository.HotelRepository;
import com.epam.lab.task.agency.repository.datasource.GenericDataSource;
import com.epam.lab.task.agency.repository.specification.impl.HotelSpecificationById;
import com.epam.lab.task.agency.resources.hotel.HotelDataProvider;
import com.epam.lab.task.agency.resources.hotel.HotelTestResource;
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
public class HotelRepositoryImplTest extends HotelDataProvider {
    private GenericDataSource<Hotel, Long> dataSource;
    private HotelRepository underTest;
    private Collection<Hotel> hotelCollection;

    @Before
    public void doSetup() {
        dataSource = mock(GenericDataSource.class);
        underTest = new HotelRepositoryImpl(dataSource);
        hotelCollection = mock(Collection.class);
    }

    @Test
    @UseDataProvider("validHotelAndOptional")
    public void shouldReturnOptionalHotelWhenSavedHotelIsValid(Hotel hotel, Optional<Hotel> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(hotelCollection);
        when(dataSource.insert(any(Hotel.class))).thenReturn(expectedResult);

        Optional<Hotel> actualValue = underTest.save(hotel);

        verify(dataSource, times(1)).insert(any(Hotel.class));
        Assert.assertEquals(actualValue, expectedResult);
    }

    @Test
    @UseDataProvider("validHotelEmptyOptional")
    public void shouldReturnOptionalHotelWhenSavedHotelInvalid(Hotel hotel, Optional<Hotel> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(hotelCollection);
        when(dataSource.insert(any(Hotel.class))).thenReturn(expectedResult);

        Optional<Hotel> actualResult = underTest.save(hotel);

        verify(dataSource, times(1)).insert(any(Hotel.class));
        Assert.assertFalse(expectedResult.isPresent());
        Assert.assertFalse(actualResult.isPresent());
    }

    @Test
    @UseDataProvider("validHotel")
    public void shouldDeleteHotelWhenDeletedHotelIsValid(Hotel hotel) {
        when(dataSource.getDataSource()).thenReturn(hotelCollection);

        underTest.delete(hotel);

        verify(dataSource, times(1)).delete(any(Hotel.class));
    }

    @Test
    @UseDataProvider("validHotelAndOptional")
    public void shouldUpdateHotelWhenUpdatedHotelIsValid(Hotel hotel, Optional<Hotel> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(hotelCollection);
        when(dataSource.update(any(Hotel.class))).thenReturn(expectedResult);

        Optional<Hotel> actualResult = underTest.update(hotel);

        verify(dataSource, times(1)).update(any(Hotel.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @UseDataProvider("validHotelEmptyOptional")
    public void shouldReturnOptionalHotelWhenUpdatedHotelInvalid(Hotel hotel, Optional<Hotel> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(hotelCollection);
        when(dataSource.update(any(Hotel.class))).thenReturn(expectedResult);

        Optional<Hotel> actualResult = underTest.update(hotel);

        verify(dataSource, times(1)).update(any(Hotel.class));
        Assert.assertFalse(expectedResult.isPresent());
        Assert.assertFalse(actualResult.isPresent());
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptionalCollection")
    public void shouldReturnHotelCollectionWhenSpecificationSatisfies(HotelSpecificationById specificationById, Optional<Collection<Hotel>> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(hotelCollection);
        when(dataSource.findAllByCriteria(any(HotelSpecificationById.class))).thenReturn(expectedResult);

        Optional<Collection<Hotel>> actualResult = underTest.findAll(specificationById);

        verify(dataSource, times(1)).findAllByCriteria(any(HotelSpecificationById.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @UseDataProvider("invalidSpecificationById")
    public void shouldReturnHotelCollectionWhenSpecificationNotSatisfies(HotelSpecificationById specificationById) {
        when(dataSource.getDataSource()).thenReturn(hotelCollection);
        when(dataSource.findAllByCriteria(any(HotelSpecificationById.class))).thenReturn(HotelTestResource.EMPTY_OPTIONAL_HOTEL_COLLECTION);

        Optional<Collection<Hotel>> actualResult = underTest.findAll(specificationById);

        verify(dataSource, times(1)).findAllByCriteria(any(HotelSpecificationById.class));
        Assert.assertFalse(actualResult.isPresent());
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptional")
    public void shouldReturnHotelWhenSpecificationSatisfies(HotelSpecificationById specificationById, Optional<Hotel> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(hotelCollection);
        when(dataSource.findOneByCriteria(any(HotelSpecificationById.class))).thenReturn(expectedResult);

        Optional<Hotel> actualResult = underTest.findOne(specificationById);

        verify(dataSource, times(1)).findOneByCriteria(any(HotelSpecificationById.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @UseDataProvider("invalidSpecificationById")
    public void shouldReturnHotelWhenSpecificationNotSatisfies(HotelSpecificationById specificationById) {
        when(dataSource.getDataSource()).thenReturn(hotelCollection);
        when(dataSource.findOneByCriteria(any(HotelSpecificationById.class))).thenReturn(HotelTestResource.EMPTY_OPTIONAL_HOTEL);

        Optional<Hotel> actualResult = underTest.findOne(specificationById);

        verify(dataSource, times(1)).findOneByCriteria(any(HotelSpecificationById.class));
        Assert.assertFalse(actualResult.isPresent());
    }
}
