package com.epam.lab.task.agency.resources.user;

import com.tngtech.java.junit.dataprovider.DataProvider;

public class UserDataProvider {
    @DataProvider
    public static Object[][] invalidSpecificationById() {
        return new Object[][]{
                {UserTestResource.INVALID_USER_SPECIFICATION_BY_ID_1},
                {UserTestResource.INVALID_USER_SPECIFICATION_BY_ID_2},
                {UserTestResource.INVALID_USER_SPECIFICATION_BY_ID_3}
        };
    }

    @DataProvider
    public static Object[][] validUserAndOptional() {
        return new Object[][]{
                {UserTestResource.getValidUser1(), UserTestResource.getOptionalUser1()},
                {UserTestResource.getValidUser2(), UserTestResource.getOptionalUser2()},
                {UserTestResource.getValidUser3(), UserTestResource.getOptionalUser3()}
        };
    }

    @DataProvider
    public static Object[][] validUser() {
        return new Object[][]{
                {UserTestResource.getValidUser1()},
                {UserTestResource.getValidUser2()},
                {UserTestResource.getValidUser3()}
        };
    }

    @DataProvider
    public static Object[][] validSpecificationById() {
        return new Object[][]{
                {UserTestResource.getInvalidUserSpecificationById1()},
                {UserTestResource.getInvalidUserSpecificationById2()},
                {UserTestResource.getInvalidUserSpecificationById3()}
        };
    }

    @DataProvider
    public static Object[][] validSpecificationByIdAndOptional() {
        return new Object[][]{
                {UserTestResource.getInvalidUserSpecificationById1(), UserTestResource.getOptionalUser1()},
                {UserTestResource.getInvalidUserSpecificationById2(), UserTestResource.getOptionalUser2()},
                {UserTestResource.getInvalidUserSpecificationById3(), UserTestResource.getOptionalUser3()}
        };
    }

    @DataProvider
    public static Object[][] validSpecificationByIdAndOptionalCollection() {
        return new Object[][]{
                {UserTestResource.getInvalidUserSpecificationById1(), UserTestResource.getOptionalUserCollection()},
                {UserTestResource.getInvalidUserSpecificationById2(), UserTestResource.getOptionalUserCollection()},
                {UserTestResource.getInvalidUserSpecificationById3(), UserTestResource.getOptionalUserCollection()}
        };
    }

    @DataProvider
    public static Object[][] validUserCollection() {
        return new Object[][]{
                {UserTestResource.getUserCollection()}
        };
    }

    @DataProvider
    public static Object[][] validUserEmptyOptional() {
        return new Object[][]{
                {UserTestResource.getValidUser1(), UserTestResource.EMPTY_OPTIONAL_USER},
                {UserTestResource.getValidUser2(), UserTestResource.EMPTY_OPTIONAL_USER},
                {UserTestResource.getValidUser3(), UserTestResource.EMPTY_OPTIONAL_USER}
        };
    }
}
