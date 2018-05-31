package com.epam.lab.task.agency.service.impl;

import com.epam.lab.task.agency.entity.Hotel;
import com.epam.lab.task.agency.repository.HotelRepository;
import com.epam.lab.task.agency.repository.impl.HotelRepositoryImpl;
import com.epam.lab.task.agency.repository.specification.impl.HotelSpecificationById;
import com.epam.lab.task.agency.resources.hotel.HotelDataProvider;
import com.epam.lab.task.agency.resources.hotel.HotelTestResource;
import com.epam.lab.task.agency.service.HotelService;
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
public class HotelServiceImplTest extends HotelDataProvider {
    private HotelService underTest;
    private HotelRepository hotelRepository;

    @Before
    public void doSetup() {
        hotelRepository = mock(HotelRepositoryImpl.class);
        underTest = new HotelServiceImpl(hotelRepository);
    }

    @Test
    @UseDataProvider("validHotelAndOptional")
    public void shouldReturnHotelWhenSavedHotelIsValid(Hotel hotel, Optional<Hotel> expectedResult) {
        when(hotelRepository.save(any(Hotel.class))).thenReturn(expectedResult);

        Hotel actualResult = underTest.save(hotel);

        verify(hotelRepository, times(1)).save(any(Hotel.class));
        Assert.assertTrue(expectedResult.isPresent());
        Assert.assertEquals(actualResult, expectedResult.get());
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validHotel")
    public void shouldThrowServiceExceptionWhenSavedHotelInvalid(Hotel hotel) {
        when(hotelRepository.save(any(Hotel.class))).thenReturn(HotelTestResource.EMPTY_OPTIONAL_HOTEL);

        underTest.save(hotel);
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptionalCollection")
    public void shouldDeleteHotelWhenDeletedHotelIsValid(HotelSpecificationById specificationById, Optional<Collection<Hotel>> expectedResult) {
        when(hotelRepository.findAll(any(HotelSpecificationById.class))).thenReturn(expectedResult);

        underTest.delete(specificationById);

        verify(hotelRepository, times(1)).delete(anyCollectionOf(Hotel.class));
    }

    @Test
    @UseDataProvider("validHotelAndOptional")
    public void shouldReturnHotelWhenUpdatedHotelIsValid(Hotel hotel, Optional<Hotel> expectedResult) {
        when(hotelRepository.update(any(Hotel.class))).thenReturn(expectedResult);

        Hotel actualResult = underTest.update(hotel);

        verify(hotelRepository, times(1)).update(any(Hotel.class));
        Assert.assertTrue(expectedResult.isPresent());
        Assert.assertEquals(actualResult, expectedResult.get());
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validHotel")
    public void shouldThrowServiceExceptionWhenUpdatedHotelInvalid(Hotel hotel) {
        when(hotelRepository.update(any(Hotel.class))).thenReturn(HotelTestResource.EMPTY_OPTIONAL_HOTEL);

        underTest.update(hotel);
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptional")
    public void shouldReturnHotelWhenFoundedHotelIsValid(HotelSpecificationById specificationById, Optional<Hotel> expectedResult) {
        when(hotelRepository.findOne(any(HotelSpecificationById.class))).thenReturn(expectedResult);

        Hotel actualResult = underTest.findOne(specificationById);

        verify(hotelRepository, times(1)).findOne(any(HotelSpecificationById.class));
        Assert.assertTrue(expectedResult.isPresent());
        Assert.assertEquals(actualResult, expectedResult.get());
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validSpecificationById")
    public void shouldThrowServiceExceptionWhenFoundedHotelInvalid(HotelSpecificationById specificationById) {
        when(hotelRepository.findOne(any(HotelSpecificationById.class))).thenReturn(HotelTestResource.EMPTY_OPTIONAL_HOTEL);

        underTest.findOne(specificationById);
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptionalCollection")
    public void shouldReturnHotelCollectionWhenFoundedCollectionIsValid(HotelSpecificationById specificationById, Optional<Collection<Hotel>> expectedResult) {
        when(hotelRepository.findAll(any(HotelSpecificationById.class))).thenReturn(expectedResult);

        Collection<Hotel> actualResult = underTest.findAll(specificationById);

        verify(hotelRepository, times(1)).findAll(any(HotelSpecificationById.class));
        Assert.assertTrue(expectedResult.isPresent());
        Assert.assertEquals(actualResult, expectedResult.get());
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validSpecificationById")
    public void shouldThrowServiceExceptionWhenFoundedCollectionInvalid(HotelSpecificationById specificationById) {
        when(hotelRepository.findAll(any(HotelSpecificationById.class))).thenReturn(HotelTestResource.EMPTY_OPTIONAL_HOTEL_COLLECTION);

        underTest.findAll(specificationById);
    }
}
