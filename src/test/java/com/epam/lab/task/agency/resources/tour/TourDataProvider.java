package com.epam.lab.task.agency.resources.tour;

import com.tngtech.java.junit.dataprovider.DataProvider;

public class TourDataProvider {
    @DataProvider
    public static Object[][] invalidSpecificationById() {
        return new Object[][]{
                {TourTestResource.INVALID_TOUR_SPECIFICATION_BY_ID_1},
                {TourTestResource.INVALID_TOUR_SPECIFICATION_BY_ID_2},
                {TourTestResource.INVALID_TOUR_SPECIFICATION_BY_ID_3}
        };
    }

    @DataProvider
    public static Object[][] validTourAndOptional() {
        return new Object[][]{
                {TourTestResource.getValidTour1(), TourTestResource.getOptionalTour1()},
                {TourTestResource.getValidTour2(), TourTestResource.getOptionalTour2()},
                {TourTestResource.getValidTour3(), TourTestResource.getOptionalTour3()}
        };
    }

    @DataProvider
    public static Object[][] validTour() {
        return new Object[][]{
                {TourTestResource.getValidTour1()},
                {TourTestResource.getValidTour2()},
                {TourTestResource.getValidTour3()}
        };
    }

    @DataProvider
    public static Object[][] validSpecificationById() {
        return new Object[][]{
                {TourTestResource.getTourSpecificationById1()},
                {TourTestResource.getTourSpecificationById2()},
                {TourTestResource.getTourSpecificationById3()}
        };
    }

    @DataProvider
    public static Object[][] validSpecificationByIdAndOptional() {
        return new Object[][]{
                {TourTestResource.getTourSpecificationById1(), TourTestResource.getOptionalTour1()},
                {TourTestResource.getTourSpecificationById2(), TourTestResource.getOptionalTour2()},
                {TourTestResource.getTourSpecificationById3(), TourTestResource.getOptionalTour3()}
        };
    }

    @DataProvider
    public static Object[][] validSpecificationByIdAndOptionalCollection() {
        return new Object[][]{
                {TourTestResource.getTourSpecificationById1(), TourTestResource.getOptionalTourCollection()},
                {TourTestResource.getTourSpecificationById2(), TourTestResource.getOptionalTourCollection()},
                {TourTestResource.getTourSpecificationById3(), TourTestResource.getOptionalTourCollection()}
        };
    }

    @DataProvider
    public static Object[][] validTourCollection() {
        return new Object[][]{
                {TourTestResource.getTourCollection()}
        };
    }

    @DataProvider
    public static Object[][] validTourEmptyOptional() {
        return new Object[][]{
                {TourTestResource.getValidTour1(), TourTestResource.EMPTY_OPTIONAL_TOUR},
                {TourTestResource.getValidTour2(), TourTestResource.EMPTY_OPTIONAL_TOUR},
                {TourTestResource.getValidTour3(), TourTestResource.EMPTY_OPTIONAL_TOUR}
        };
    }
}
