package com.epam.lab.task.agency.resources.user;

import com.epam.lab.task.agency.entity.Review;
import com.epam.lab.task.agency.entity.Tour;
import com.epam.lab.task.agency.entity.User;
import com.epam.lab.task.agency.repository.specification.impl.UserSpecificationById;
import com.epam.lab.task.agency.resources.review.ReviewTestResource;
import com.epam.lab.task.agency.resources.tour.TourTestResource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class UserTestResource {
    public static final UserSpecificationById INVALID_USER_SPECIFICATION_BY_ID_1 = new UserSpecificationById(2345L);
    public static final UserSpecificationById INVALID_USER_SPECIFICATION_BY_ID_2 = new UserSpecificationById(999L);
    public static final UserSpecificationById INVALID_USER_SPECIFICATION_BY_ID_3 = new UserSpecificationById(4564575L);
    public static final Optional<User> EMPTY_OPTIONAL_USER = Optional.empty();
    public static final Optional<Collection<User>> EMPTY_OPTIONAL_USER_COLLECTION = Optional.empty();

    private static User createUser(long id, String jj, String gm2zcxv9123G) {
        User user = new User();
        user.setId(id);
        user.setLogin(jj);
        user.setPassword(gm2zcxv9123G);
        user.setReviews((List<Review>) ReviewTestResource.getReviewCollection());
        user.setTours((List<Tour>) TourTestResource.getTourCollection());
        return user;
    }

    public static User getValidUser1() {
        User user = createUser(1L, "AlexNosko", "Eye1essDude");
        return user;
    }

    public static User getValidUser2() {
        User user = createUser(2L, "DmitryNosko", "m8hs92fdsv");
        return user;
    }

    public static User getValidUser3() {
        return createUser(3L, "JJ", "gm2zcxv9123G");
    }

    public static Optional<User> getOptionalUser1() {
        return Optional.of(getValidUser1());
    }

    public static Optional<User> getOptionalUser2() {
        return Optional.of(getValidUser2());
    }

    public static Optional<User> getOptionalUser3() {
        return Optional.of(getValidUser3());
    }

    public static UserSpecificationById getInvalidUserSpecificationById1() {
        return new UserSpecificationById(getValidUser1().getId());
    }

    public static UserSpecificationById getInvalidUserSpecificationById2() {
        return new UserSpecificationById(getValidUser2().getId());
    }

    public static UserSpecificationById getInvalidUserSpecificationById3() {
        return new UserSpecificationById(getValidUser3().getId());
    }

    public static Collection<User> getUserCollection() {
        List<User> users = new ArrayList<>();
        users.add(getValidUser1());
        users.add(getValidUser2());
        users.add(getValidUser3());
        return users;
    }

    public static Optional<Collection<User>> getOptionalUserCollection() {
        return Optional.of(getUserCollection());
    }
}
