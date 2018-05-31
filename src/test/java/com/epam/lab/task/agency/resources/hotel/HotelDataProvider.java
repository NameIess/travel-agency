package com.epam.lab.task.agency.resources.hotel;

import com.tngtech.java.junit.dataprovider.DataProvider;

public class HotelDataProvider {
    @DataProvider
    public static Object[][] invalidSpecificationById() {
        return new Object[][]{
                {HotelTestResource.INVALID_HOTEL_SPECIFICATION_BY_ID_1},
                {HotelTestResource.INVALID_HOTEL_SPECIFICATION_BY_ID_2},
                {HotelTestResource.INVALID_HOTEL_SPECIFICATION_BY_ID_3}
        };
    }

    @DataProvider
    public static Object[][] validHotelAndOptional() {
        return new Object[][]{
                {HotelTestResource.getValidHotel1(), HotelTestResource.getOptionalHotel1()},
                {HotelTestResource.getValidHotel2(), HotelTestResource.getOptionalHotel2()},
                {HotelTestResource.getValidHotel3(), HotelTestResource.getOptionalHotel3()}
        };
    }

    @DataProvider
    public static Object[][] validHotel() {
        return new Object[][]{
                {HotelTestResource.getValidHotel1()},
                {HotelTestResource.getValidHotel2()},
                {HotelTestResource.getValidHotel3()}
        };
    }

    @DataProvider
    public static Object[][] validSpecificationById() {
        return new Object[][]{
                {HotelTestResource.getHotelSpecificationById1()},
                {HotelTestResource.getHotelSpecificationById2()},
                {HotelTestResource.getHotelSpecificationById3()}
        };
    }

    @DataProvider
    public static Object[][] validSpecificationByIdAndOptional() {
        return new Object[][]{
                {HotelTestResource.getHotelSpecificationById1(), HotelTestResource.getOptionalHotel1()},
                {HotelTestResource.getHotelSpecificationById2(), HotelTestResource.getOptionalHotel2()},
                {HotelTestResource.getHotelSpecificationById3(), HotelTestResource.getOptionalHotel3()}
        };
    }

    @DataProvider
    public static Object[][] validSpecificationByIdAndOptionalCollection() {
        return new Object[][]{
                {HotelTestResource.getHotelSpecificationById1(), HotelTestResource.getOptionalHotelCollection()},
                {HotelTestResource.getHotelSpecificationById2(), HotelTestResource.getOptionalHotelCollection()},
                {HotelTestResource.getHotelSpecificationById3(), HotelTestResource.getOptionalHotelCollection()}
        };
    }

    @DataProvider
    public static Object[][] validHotelCollection() {
        return new Object[][]{
                {HotelTestResource.getHotelCollection()}
        };
    }

    @DataProvider
    public static Object[][] validHotelEmptyOptional() {
        return new Object[][]{
                {HotelTestResource.getValidHotel1(), HotelTestResource.EMPTY_OPTIONAL_HOTEL},
                {HotelTestResource.getValidHotel2(), HotelTestResource.EMPTY_OPTIONAL_HOTEL},
                {HotelTestResource.getValidHotel3(), HotelTestResource.EMPTY_OPTIONAL_HOTEL}
        };
    }
}
