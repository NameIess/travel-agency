package com.epam.lab.task.agency.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Tour domain entity.
 */
public class Tour implements Identified<Long> {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String image;
    private LocalDate localDate;
    private String duration;
    private String description;
    private BigDecimal cost;
    private TourType tourType;
    private Country country;
    private List<Review> reviews;
    private List<Hotel> hotels;

    /**
     * Default constructor.
     */
    public Tour() {
        // Instantiates tour
    }

    public void addReview(Review review) {
        if (this.reviews == null) {
            reviews = new ArrayList<>();
        }
        this.reviews.add(review);
    }

    public void addHotel(Hotel hotel) {
        if (this.hotels == null) {
            hotels = new ArrayList<>();
        }
        this.hotels.add(hotel);
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Tour tour = (Tour) o;

        if (id != null ? !id.equals(tour.id) : tour.id != null) {
            return false;
        }

        if (image != null ? !image.equals(tour.image) : tour.image != null) {
            return false;
        }

        if (localDate != null ? !localDate.equals(tour.localDate) : tour.localDate != null) {
            return false;
        }

        if (duration != null ? !duration.equals(tour.duration) : tour.duration != null) {
            return false;
        }

        if (description != null ? !description.equals(tour.description) : tour.description != null) {
            return false;
        }

        if (cost != null ? !cost.equals(tour.cost) : tour.cost != null) {
            return false;
        }

        return tourType == tour.tourType;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (localDate != null ? localDate.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (tourType != null ? tourType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", localDate=" + localDate +
                ", duration='" + duration + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
