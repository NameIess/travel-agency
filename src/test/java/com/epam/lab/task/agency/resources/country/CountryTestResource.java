package com.epam.lab.task.agency.resources.country;

import com.epam.lab.task.agency.entity.Country;
import com.epam.lab.task.agency.repository.specification.impl.CountrySpecificationById;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class CountryTestResource {
    public static final CountrySpecificationById INVALID_COUNTRY_SPECIFICATION_BY_ID_1 = new CountrySpecificationById(2345L);
    public static final CountrySpecificationById INVALID_COUNTRY_SPECIFICATION_BY_ID_2 = new CountrySpecificationById(999L);
    public static final CountrySpecificationById INVALID_COUNTRY_SPECIFICATION_BY_ID_3 = new CountrySpecificationById(4564575L);
    public static final Optional<Country> EMPTY_OPTIONAL_COUNTRY = Optional.empty();
    public static final Optional<Collection<Country>> EMPTY_OPTIONAL_COUNTRY_COLLECTION = Optional.empty();

    private static Country createCountry(long id, String belarus) {
        Country country = new Country();
        country.setId(id);
        country.setName(belarus);
        return country;
    }

    public static Optional<Country> getOptionalCountry1() {
        return Optional.of(getValidCountry1());
    }

    public static Optional<Country> getOptionalCountry2() {
        return Optional.of(getValidCountry2());
    }

    public static Optional<Country> getOptionalCountry3() {
        return Optional.of(getValidCountry3());
    }

    public static Optional<Collection<Country>> getOptionalCountryCollection() {
        return Optional.of(getCountryCollection());
    }

    public static CountrySpecificationById getCountrySpecification1() {
        CountrySpecificationById byId = new CountrySpecificationById(getValidCountry1().getId());
        return byId;
    }

    public static CountrySpecificationById getCountrySpecification2() {
        CountrySpecificationById byId = new CountrySpecificationById(getValidCountry2().getId());
        return byId;
    }

    public static CountrySpecificationById getCountrySpecification3() {
        CountrySpecificationById byId = new CountrySpecificationById(getValidCountry3().getId());
        return byId;
    }

    public static Country getValidCountry1() {
        return createCountry(1L, "Belarus");
    }

    public static Country getValidCountry2() {
        return createCountry(2L, "Poland");
    }

    public static Country getValidCountry3() {
        return createCountry(3L, "Latvia");
    }

    public static Collection<Country> getCountryCollection() {
        List<Country> countries = new ArrayList<>();
        countries.add(getValidCountry1());
        countries.add(getValidCountry2());
        countries.add(getValidCountry3());
        return countries;
    }
}
