package com.epam.lab.task.agency.resources.tour;

import com.epam.lab.task.agency.entity.*;
import com.epam.lab.task.agency.repository.specification.impl.TourSpecificationById;
import com.epam.lab.task.agency.resources.country.CountryTestResource;
import com.epam.lab.task.agency.resources.hotel.HotelTestResource;
import com.epam.lab.task.agency.resources.review.ReviewTestResource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class TourTestResource {
    public static final TourSpecificationById INVALID_TOUR_SPECIFICATION_BY_ID_1 = new TourSpecificationById(2345L);
    public static final TourSpecificationById INVALID_TOUR_SPECIFICATION_BY_ID_2 = new TourSpecificationById(999L);
    public static final TourSpecificationById INVALID_TOUR_SPECIFICATION_BY_ID_3 = new TourSpecificationById(4564575L);
    public static final Optional<Tour> EMPTY_OPTIONAL_TOUR = Optional.empty();
    public static final Optional<Collection<Tour>> EMPTY_OPTIONAL_TOUR_COLLECTION = Optional.empty();

    private static Tour createTour(long id, BigDecimal cost, Country validCountry3, String description, String duration, String image, TourType christmasTour, LocalDate of) {
        Tour tour = new Tour();
        tour.setId(id);
        tour.setCost(cost);
        tour.setCountry(validCountry3);
        tour.setReviews((List<Review>) ReviewTestResource.getReviewCollection());
        tour.setDescription(description);
        tour.setDuration(duration);
        tour.setHotels((List<Hotel>) HotelTestResource.getHotelCollection());
        tour.setImage(image);
        tour.setTourType(christmasTour);
        tour.setLocalDate(of);
        return tour;
    }

    public static Tour getValidTour1() {
        Tour tour = createTour(1L, new BigDecimal("1700.00"), CountryTestResource.getValidCountry1(), "Europe tour", "3 month", "/home/admin/europe/tour.png", TourType.BUS_TOUR, LocalDate.of(2018, 2, 21));
        return tour;
    }

    public static Tour getValidTour2() {
        Tour tour = createTour(2L, new BigDecimal("700.00"), CountryTestResource.getValidCountry2(), "France trip", "2 weeks", "/home/admin/paris.png", TourType.EXCURSION_TOUR, LocalDate.of(2018, 12, 21));
        return tour;
    }

    public static Tour getValidTour3() {
        return createTour(3L, new BigDecimal("2500.10"), CountryTestResource.getValidCountry3(), "Koln excursion", "1 week", "/home/admin/germany/koln.png", TourType.CHRISTMAS_TOUR, LocalDate.of(2017, 12, 21));
    }

    public static Optional<Tour> getOptionalTour1() {
        return Optional.of(getValidTour1());
    }

    public static Optional<Tour> getOptionalTour2() {
        return Optional.of(getValidTour2());
    }

    public static Optional<Tour> getOptionalTour3() {
        return Optional.of(getValidTour3());
    }

    public static TourSpecificationById getTourSpecificationById1() {
        return new TourSpecificationById(getValidTour1().getId());
    }

    public static TourSpecificationById getTourSpecificationById2() {
        return new TourSpecificationById(getValidTour2().getId());
    }

    public static TourSpecificationById getTourSpecificationById3() {
        return new TourSpecificationById(getValidTour3().getId());
    }

    public static Collection<Tour> getTourCollection() {
        List<Tour> tours = new ArrayList<>();
        tours.add(getValidTour1());
        tours.add(getValidTour2());
        tours.add(getValidTour3());
        return tours;
    }

    public static Optional<Collection<Tour>> getOptionalTourCollection() {
        return Optional.of(getTourCollection());
    }
}
