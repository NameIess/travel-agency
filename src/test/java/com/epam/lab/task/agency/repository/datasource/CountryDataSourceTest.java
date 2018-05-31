package com.epam.lab.task.agency.repository.datasource;

import com.epam.lab.task.agency.entity.Country;
import com.epam.lab.task.agency.resources.country.CountryDataProvider;
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

import static org.mockito.Mockito.*;

@RunWith(DataProviderRunner.class)
public class CountryDataSourceTest extends CountryDataProvider {
    private GenericDataSource<Country, Long> underTest;
    private Collection<Country> countryCollection;

    @Before
    public void doSetup() {
        underTest = CountryDataSource.getInstance();
        countryCollection = mock(ArrayList.class);
        underTest.setDataSource(countryCollection);
    }

    @Test
    @UseDataProvider("validCountryCollection")
    public void shouldDeleteCountryCollectionWhenDeletedCountryIsValid(Collection<Country> countries) {
        underTest.delete(countries);

        verify(countryCollection, times(1)).removeAll(anyCollectionOf(Country.class));
    }

    @Test
    @UseDataProvider("validCountryAndOptional")
    public void shouldUpdateCountryWhenUpdatedCountryIsValid(Country country, Optional<Country> expectedResult) {
        when(countryCollection.removeIf(any(Predicate.class))).thenReturn(true);

        Optional<Country> actualResult = underTest.update(country);

        verify(countryCollection, times(1)).add(any(Country.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @UseDataProvider("validCountryEmptyOptional")
    public void shouldUpdateCountryWhenUpdatedCountryInvalid(Country country, Optional<Country> expectedResult) {
        when(countryCollection.removeIf(any(Predicate.class))).thenReturn(false);

        Optional<Country> actualResult = underTest.update(country);

        verify(countryCollection, times(0)).add(any(Country.class));
        Assert.assertEquals(actualResult, expectedResult);
    }
}
