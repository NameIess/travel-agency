package com.epam.lab.task.agency.entity;

/**
 * Review domain entity.
 */
public class Review implements Identified<Long> {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String content;
    private User user;
    private Tour tour;

    /**
     * Default constructor.
     */
    public Review() {
        // Instantiates review
    }

    public void addUser(User user) {
        this.user = user;
        user.addReview(this);
    }

    public void addTour(Tour tour) {
        this.tour = tour;
        tour.addReview(this);
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Review review = (Review) o;

        if (id != null ? !id.equals(review.id) : review.id != null) {
            return false;
        }

        return content != null ? content.equals(review.content) : review.content == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
