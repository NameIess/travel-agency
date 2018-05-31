package com.epam.lab.task.agency.entity;

/**
 * Tour type.
 */
public enum TourType {
    WEEDING_TOUR("Weeding tour"),
    CHRISTMAS_TOUR("Christmas tour"),
    BUS_TOUR("Bus tour"),
    CHILD_CAMP("Child camp"),
    EXCURSION_TOUR("Excursion tour"),
    SKI_TOUR("Ski tour");

    private String name;

    TourType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TourType{" +
                "name='" + name + '\'' +
                '}';
    }
}
