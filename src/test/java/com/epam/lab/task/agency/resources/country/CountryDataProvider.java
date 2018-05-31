package com.epam.lab.task.agency.resources.country;

import com.tngtech.java.junit.dataprovider.DataProvider;

public class CountryDataProvider {

    @DataProvider
    public static Object[][] validCountryAndOptional() {
        return new Object[][]{
                {CountryTestResource.getValidCountry1(), CountryTestResource.getOptionalCountry1()},
                {CountryTestResource.getValidCountry2(), CountryTestResource.getOptionalCountry2()},
                {CountryTestResource.getValidCountry3(), CountryTestResource.getOptionalCountry3()}
        };
    }

    @DataProvider
    public static Object[][] validCountry() {
        return new Object[][]{
                {CountryTestResource.getValidCountry1()},
                {CountryTestResource.getValidCountry2()},
                {CountryTestResource.getValidCountry3()}
        };
    }

    @DataProvider
    public static Object[][] validSpecificationByIdAndOptional() {
        return new Object[][]{
                {CountryTestResource.getCountrySpecification1(), CountryTestResource.getOptionalCountry1()},
                {CountryTestResource.getCountrySpecification2(), CountryTestResource.getOptionalCountry2()},
                {CountryTestResource.getCountrySpecification3(), CountryTestResource.getOptionalCountry3()}
        };
    }

    @DataProvider
    public static Object[][] validSpecificationByIdAndOptionalCollection() {
        return new Object[][]{
                {CountryTestResource.getCountrySpecification1(), CountryTestResource.getOptionalCountryCollection()},
                {CountryTestResource.getCountrySpecification2(), CountryTestResource.getOptionalCountryCollection()},
                {CountryTestResource.getCountrySpecification3(), CountryTestResource.getOptionalCountryCollection()}
        };
    }

    @DataProvider
    public static Object[][] validSpecificationById() {
        return new Object[][]{
                {CountryTestResource.getCountrySpecification1()},
                {CountryTestResource.getCountrySpecification2()},
                {CountryTestResource.getCountrySpecification3()}
        };
    }

    @DataProvider
    public static Object[][] invalidSpecificationById() {
        return new Object[][]{
                {CountryTestResource.INVALID_COUNTRY_SPECIFICATION_BY_ID_1},
                {CountryTestResource.INVALID_COUNTRY_SPECIFICATION_BY_ID_2},
                {CountryTestResource.INVALID_COUNTRY_SPECIFICATION_BY_ID_3}
        };
    }

    @DataProvider
    public static Object[][] validCountryCollection() {
        return new Object[][]{
                {CountryTestResource.getCountryCollection()}
        };
    }

    @DataProvider
    public static Object[][] validCountryEmptyOptional() {
        return new Object[][]{
                {CountryTestResource.getValidCountry1(), CountryTestResource.EMPTY_OPTIONAL_COUNTRY},
                {CountryTestResource.getValidCountry2(), CountryTestResource.EMPTY_OPTIONAL_COUNTRY},
                {CountryTestResource.getValidCountry3(), CountryTestResource.EMPTY_OPTIONAL_COUNTRY}
        };
    }
}
