package com.epam.lab.task.agency.resources.review;

import com.tngtech.java.junit.dataprovider.DataProvider;

public class ReviewDataProvider {
    @DataProvider
    public static Object[][] invalidSpecificationById() {
        return new Object[][]{
                {ReviewTestResource.INVALID_REVIEW_SPECIFICATION_BY_ID_1},
                {ReviewTestResource.INVALID_REVIEW_SPECIFICATION_BY_ID_2},
                {ReviewTestResource.INVALID_REVIEW_SPECIFICATION_BY_ID_3}
        };
    }

    @DataProvider
    public static Object[][] validReviewAndOptional() {
        return new Object[][]{
                {ReviewTestResource.getValidReview1(), ReviewTestResource.getOptionalReview1()},
                {ReviewTestResource.getValidReview2(), ReviewTestResource.getOptionalReview2()},
                {ReviewTestResource.getValidReview3(), ReviewTestResource.getOptionalReview3()}
        };
    }

    @DataProvider
    public static Object[][] validReview() {
        return new Object[][]{
                {ReviewTestResource.getValidReview1()},
                {ReviewTestResource.getValidReview2()},
                {ReviewTestResource.getValidReview3()}
        };
    }

    @DataProvider
    public static Object[][] validSpecificationById() {
        return new Object[][]{
                {ReviewTestResource.getReviewSpecificationById1()},
                {ReviewTestResource.getReviewSpecificationById2()},
                {ReviewTestResource.getReviewSpecificationById3()}
        };
    }

    @DataProvider
    public static Object[][] validSpecificationByIdAndOptional() {
        return new Object[][]{
                {ReviewTestResource.getReviewSpecificationById1(), ReviewTestResource.getOptionalReview1()},
                {ReviewTestResource.getReviewSpecificationById2(), ReviewTestResource.getOptionalReview2()},
                {ReviewTestResource.getReviewSpecificationById3(), ReviewTestResource.getOptionalReview3()}
        };
    }

    @DataProvider
    public static Object[][] validSpecificationByIdAndOptionalCollection() {
        return new Object[][]{
                {ReviewTestResource.getReviewSpecificationById1(), ReviewTestResource.getOptionalReviewCollection()},
                {ReviewTestResource.getReviewSpecificationById2(), ReviewTestResource.getOptionalReviewCollection()},
                {ReviewTestResource.getReviewSpecificationById3(), ReviewTestResource.getOptionalReviewCollection()}
        };
    }

    @DataProvider
    public static Object[][] validReviewCollection() {
        return new Object[][]{
                {ReviewTestResource.getReviewCollection()}
        };
    }

    @DataProvider
    public static Object[][] validReviewEmptyOptional() {
        return new Object[][]{
                {ReviewTestResource.getValidReview1(), ReviewTestResource.EMPTY_OPTIONAL_REVIEW},
                {ReviewTestResource.getValidReview2(), ReviewTestResource.EMPTY_OPTIONAL_REVIEW},
                {ReviewTestResource.getValidReview3(), ReviewTestResource.EMPTY_OPTIONAL_REVIEW}
        };
    }
}
