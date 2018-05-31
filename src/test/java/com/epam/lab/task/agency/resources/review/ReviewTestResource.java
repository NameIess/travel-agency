package com.epam.lab.task.agency.resources.review;

import com.epam.lab.task.agency.entity.Review;
import com.epam.lab.task.agency.entity.Tour;
import com.epam.lab.task.agency.entity.User;
import com.epam.lab.task.agency.repository.specification.impl.ReviewSpecificationById;
import com.epam.lab.task.agency.resources.tour.TourTestResource;
import com.epam.lab.task.agency.resources.user.UserTestResource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ReviewTestResource {
    public static final ReviewSpecificationById INVALID_REVIEW_SPECIFICATION_BY_ID_1 = new ReviewSpecificationById(2345L);
    public static final ReviewSpecificationById INVALID_REVIEW_SPECIFICATION_BY_ID_2 = new ReviewSpecificationById(999L);
    public static final ReviewSpecificationById INVALID_REVIEW_SPECIFICATION_BY_ID_3 = new ReviewSpecificationById(4564575L);
    public static final Optional<Review> EMPTY_OPTIONAL_REVIEW = Optional.empty();
    public static final Optional<Collection<Review>> EMPTY_OPTIONAL_REVIEW_COLLECTION = Optional.empty();

    private static Review createReview(long id, String content) {
        Review review = new Review();
        review.setId(id);
        review.setContent(content);

        return review;
    }

    public static Review getValidReview1() {
        return createReview(1L, "Great hotel");
    }

    public static Review getValidReview2() {
        return createReview(2L, "Awesome service & hotel");
    }

    public static Review getValidReview3() {
        return createReview(3L, "Nothing special");
    }

    public static Optional<Review> getOptionalReview1() {
        return Optional.of(getValidReview1());
    }

    public static Optional<Review> getOptionalReview2() {
        return Optional.of(getValidReview2());
    }

    public static Optional<Review> getOptionalReview3() {
        return Optional.of(getValidReview3());
    }

    public static ReviewSpecificationById getReviewSpecificationById1() {
        return new ReviewSpecificationById(getValidReview1().getId());
    }

    public static ReviewSpecificationById getReviewSpecificationById2() {
        return new ReviewSpecificationById(getValidReview2().getId());
    }

    public static ReviewSpecificationById getReviewSpecificationById3() {
        return new ReviewSpecificationById(getValidReview3().getId());
    }

    public static Collection<Review> getReviewCollection() {
        List<Review> reviews = new ArrayList<>();
        reviews.add(getValidReview1());
        reviews.add(getValidReview2());
        reviews.add(getValidReview3());
        return reviews;
    }

    public static Optional<Collection<Review>> getOptionalReviewCollection() {
        return Optional.of(getReviewCollection());
    }
}
