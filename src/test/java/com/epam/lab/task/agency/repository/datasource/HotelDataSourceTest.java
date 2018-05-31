package com.epam.lab.task.agency.repository.datasource;

import com.epam.lab.task.agency.entity.Hotel;
import com.epam.lab.task.agency.resources.hotel.HotelDataProvider;
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
public class HotelDataSourceTest extends HotelDataProvider {
    private GenericDataSource<Hotel, Long> underTest;
    private Collection<Hotel> hotelCollection;

    @Before
    public void doSetup() {
        underTest = HotelDataSource.getInstance();
        hotelCollection = mock(ArrayList.class);
        underTest.setDataSource(hotelCollection);
    }

    @Test
    @UseDataProvider("validHotelCollection")
    public void shouldDeleteHotelCollectionWhenDeletedHotelIsValid(Collection<Hotel> hotels) {
        underTest.delete(hotels);

        verify(hotelCollection, times(1)).removeAll(anyCollectionOf(Hotel.class));
    }

    @Test
    @UseDataProvider("validHotelAndOptional")
    public void shouldUpdateHotelWhenUpdatedHotelIsValid(Hotel hotel, Optional<Hotel> expectedResult) {
        when(hotelCollection.removeIf(any(Predicate.class))).thenReturn(true);

        Optional<Hotel> actualResult = underTest.update(hotel);

        verify(hotelCollection, times(1)).add(any(Hotel.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @UseDataProvider("validHotelEmptyOptional")
    public void shouldUpdateHotelWhenUpdatedHotelInvalid(Hotel hotel, Optional<Hotel> expectedResult) {
        when(hotelCollection.removeIf(any(Predicate.class))).thenReturn(false);

        Optional<Hotel> actualResult = underTest.update(hotel);

        verify(hotelCollection, times(0)).add(any(Hotel.class));
        Assert.assertEquals(actualResult, expectedResult);
    }
}
