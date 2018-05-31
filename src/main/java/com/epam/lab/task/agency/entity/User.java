package com.epam.lab.task.agency.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * User domain entity.
 */
public class User implements Identified<Long> {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String login;
    private String password;
    private List<Tour> tours;
    private List<Review> reviews;

    /**
     * Default constructor.
     */
    public User() {
        // Instantiates user
    }

    public void addTour(Tour tour) {
        if (this.tours == null) {
            this.tours = new ArrayList<>();
        }
        this.tours.add(tour);
    }

    public void addReview(Review review) {
        if (this.reviews == null) {
            this.reviews = new ArrayList<>();
        }
        this.reviews.add(review);
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) {
            return false;
        }

        if (login != null ? !login.equals(user.login) : user.login != null) {
            return false;
        }

        return password != null ? password.equals(user.password) : user.password == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
