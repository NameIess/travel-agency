package com.epam.lab.task.agency.service.impl;

import com.epam.lab.task.agency.entity.Country;
import com.epam.lab.task.agency.repository.CountryRepository;
import com.epam.lab.task.agency.repository.specification.impl.CountrySpecificationById;
import com.epam.lab.task.agency.resources.country.CountryDataProvider;
import com.epam.lab.task.agency.resources.country.CountryTestResource;
import com.epam.lab.task.agency.service.CountryService;
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
public class CountryServiceImplTest extends CountryDataProvider {
    private CountryService underTest;
    private CountryRepository countryRepository;

    @Before
    public void doSetup() {
        countryRepository = mock(CountryRepository.class);
        underTest = new CountryServiceImpl(countryRepository);
    }

    @Test
    @UseDataProvider("validCountryAndOptional")
    public void shouldReturnCountryWhenSavedCountryIsValid(Country country, Optional<Country> expectedResult) {
        when(countryRepository.save(country)).thenReturn(expectedResult);

        Country actualResult = underTest.save(country);

        verify(countryRepository, times(1)).save(any(Country.class));
        Assert.assertTrue(expectedResult.isPresent());
        Assert.assertEquals(actualResult, expectedResult.get());
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validCountry")
    public void shouldThrowServiceExceptionWhenSavedCountryInvalid(Country country) {
        when(countryRepository.save(country)).thenReturn(CountryTestResource.EMPTY_OPTIONAL_COUNTRY);

        underTest.save(country);
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptionalCollection")
    public void shouldDeleteCountryWhenDeletedCountryIsValid(CountrySpecificationById specificationById, Optional<Collection<Country>> expectedResult) {
        when(countryRepository.findAll(any(CountrySpecificationById.class))).thenReturn(expectedResult);

        underTest.delete(specificationById);

        verify(countryRepository, times(1)).delete(anyCollectionOf(Country.class));
    }

    @Test
    @UseDataProvider("validCountryAndOptional")
    public void shouldReturnCountryWhenUpdatedCountryIsValid(Country country, Optional<Country> expectedResult) {
        when(countryRepository.update(country)).thenReturn(expectedResult);

        Country actualResult = underTest.update(country);

        verify(countryRepository, times(1)).update(any(Country.class));
        Assert.assertTrue(expectedResult.isPresent());
        Assert.assertEquals(actualResult, expectedResult.get());
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validCountry")
    public void shouldThrowServiceExceptionWhenUpdatedCountryInvalid(Country country) {
        when(countryRepository.update(country)).thenReturn(CountryTestResource.EMPTY_OPTIONAL_COUNTRY);

        underTest.update(country);
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptional")
    public void shouldReturnCountryWhenFoundedCountryIsValid(CountrySpecificationById specificationById, Optional<Country> expectedResult) {
        when(countryRepository.findOne(specificationById)).thenReturn(expectedResult);

        Country actualResult = underTest.findOne(specificationById);

        verify(countryRepository, times(1)).findOne(any(CountrySpecificationById.class));
        Assert.assertTrue(expectedResult.isPresent());
        Assert.assertEquals(actualResult, expectedResult.get());
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validSpecificationById")
    public void shouldThrowServiceExceptionWhenFoundedCountryInvalid(CountrySpecificationById specificationById) {
        when(countryRepository.findOne(any(CountrySpecificationById.class))).thenReturn(CountryTestResource.EMPTY_OPTIONAL_COUNTRY);

        underTest.findOne(specificationById);
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptionalCollection")
    public void shouldReturnCountryCollectionWhenSpecificationSatisfies(CountrySpecificationById specificationById, Optional<Collection<Country>> expectedResult) {
        when(countryRepository.findAll(specificationById)).thenReturn(expectedResult);

        Collection<Country> actualResult = underTest.findAll(specificationById);

        verify(countryRepository, times(1)).findAll(any(CountrySpecificationById.class));
        Assert.assertTrue(expectedResult.isPresent());
        Assert.assertEquals(actualResult, expectedResult.get());
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validSpecificationById")
    public void shouldThrowServiceExceptionWhenSpecificationNotSatisfies(CountrySpecificationById specificationById) {
        when(countryRepository.findAll(any(CountrySpecificationById.class))).thenReturn(CountryTestResource.EMPTY_OPTIONAL_COUNTRY_COLLECTION);

        underTest.findAll(specificationById);
    }
}
