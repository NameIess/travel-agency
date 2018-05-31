package com.epam.lab.task.agency.repository.impl;

import com.epam.lab.task.agency.entity.Country;
import com.epam.lab.task.agency.repository.CountryRepository;
import com.epam.lab.task.agency.repository.datasource.GenericDataSource;
import com.epam.lab.task.agency.repository.specification.impl.CountrySpecificationById;
import com.epam.lab.task.agency.resources.country.CountryDataProvider;
import com.epam.lab.task.agency.resources.country.CountryTestResource;
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
public class CountryRepositoryImplTest extends CountryDataProvider {
    private GenericDataSource<Country, Long> dataSource;
    private CountryRepository underTest;
    private Collection<Country> countryCollection;

    @Before
    public void doSetup() {
        dataSource = mock(GenericDataSource.class);
        underTest = new CountryRepositoryImpl(dataSource);
        countryCollection = mock(Collection.class);
    }

    @Test
    @UseDataProvider("validCountryAndOptional")
    public void shouldReturnOptionalCountryWhenSavedCountryIsValid(Country country, Optional<Country> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(countryCollection);
        when(dataSource.insert(any(Country.class))).thenReturn(expectedResult);

        Optional<Country> actualResult = underTest.save(country);

        verify(dataSource, times(1)).insert(any(Country.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @UseDataProvider("validCountryEmptyOptional")
    public void shouldReturnOptionalCountryWhenSavedCountryInvalid(Country country, Optional<Country> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(countryCollection);
        when(dataSource.insert(any(Country.class))).thenReturn(expectedResult);

        Optional<Country> actualResult = underTest.save(country);

        verify(dataSource, times(1)).insert(any(Country.class));
        Assert.assertFalse(expectedResult.isPresent());
        Assert.assertFalse(actualResult.isPresent());
    }

    @Test
    @UseDataProvider("validCountryCollection")
    public void shouldDeleteCountryCollectionWhenDeletedCollectionValid(Collection<Country> countries) {
        underTest.delete(countries);
        verify(dataSource, times(1)).delete(anyCollectionOf(Country.class));
    }

    @Test
    @UseDataProvider("validCountryAndOptional")
    public void shouldUpdateCountryWhenUpdatedCountryIsValid(Country country, Optional<Country> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(countryCollection);
        when(dataSource.update(any(Country.class))).thenReturn(expectedResult);

        Optional<Country> actualResult = underTest.update(country);

        verify(dataSource, times(1)).update(any(Country.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @UseDataProvider("validCountryEmptyOptional")
    public void shouldReturnOptionalCountryWhenUpdatedCountryInvalid(Country country, Optional<Country> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(countryCollection);
        when(dataSource.update(any(Country.class))).thenReturn(expectedResult);

        Optional<Country> actualResult = underTest.update(country);

        verify(dataSource, times(1)).update(any(Country.class));
        Assert.assertFalse(expectedResult.isPresent());
        Assert.assertFalse(actualResult.isPresent());
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptionalCollection")
    public void shouldReturnCountryCollectionWhenSpecificationSatisfies(CountrySpecificationById specificationById, Optional<Collection<Country>> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(countryCollection);
        when(dataSource.findAllByCriteria(any(CountrySpecificationById.class))).thenReturn(expectedResult);

        Optional<Collection<Country>> actualResult = underTest.findAll(specificationById);

        verify(dataSource, times(1)).findAllByCriteria(any(CountrySpecificationById.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @UseDataProvider("invalidSpecificationById")
    public void shouldReturnCountryCollectionWhenSpecificationNotSatisfies(CountrySpecificationById specificationById) {
        when(dataSource.getDataSource()).thenReturn(countryCollection);
        when(dataSource.findAllByCriteria(any(CountrySpecificationById.class))).thenReturn(CountryTestResource.EMPTY_OPTIONAL_COUNTRY_COLLECTION);

        Optional<Collection<Country>> actualResult = underTest.findAll(specificationById);

        verify(dataSource, times(1)).findAllByCriteria(any(CountrySpecificationById.class));
        Assert.assertFalse(actualResult.isPresent());
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptional")
    public void shouldReturnCountryWhenSpecificationSatisfies(CountrySpecificationById specificationById, Optional<Country> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(countryCollection);
        when(dataSource.findOneByCriteria(any(CountrySpecificationById.class))).thenReturn(expectedResult);

        Optional<Country> actualResult = underTest.findOne(specificationById);

        verify(dataSource, times(1)).findOneByCriteria(any(CountrySpecificationById.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @UseDataProvider("invalidSpecificationById")
    public void shouldReturnCountryWhenSpecificationNotSatisfies(CountrySpecificationById specificationById) {
        when(dataSource.getDataSource()).thenReturn(countryCollection);
        when(dataSource.findOneByCriteria(any(CountrySpecificationById.class))).thenReturn(CountryTestResource.EMPTY_OPTIONAL_COUNTRY);

        Optional<Country> actualResult = underTest.findOne(specificationById);

        verify(dataSource, times(1)).findOneByCriteria(any(CountrySpecificationById.class));
        Assert.assertFalse(actualResult.isPresent());
    }
}
