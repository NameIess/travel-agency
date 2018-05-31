package com.epam.lab.task.agency.entity;

/**
 * Hotel domain entity.
 */
public class Hotel implements Identified<Long> {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String phone;
    private Byte star;

    /**
     * Default constructor.
     */
    public Hotel() {
        // Instantiates hotel
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Byte getStar() {
        return star;
    }

    public void setStar(Byte star) {
        this.star = star;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Hotel hotel = (Hotel) o;

        if (id != null ? !id.equals(hotel.id) : hotel.id != null) {
            return false;
        }

        if (name != null ? !name.equals(hotel.name) : hotel.name != null) {
            return false;
        }

        if (phone != null ? !phone.equals(hotel.phone) : hotel.phone != null) {
            return false;
        }

        return star != null ? star.equals(hotel.star) : hotel.star == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (star != null ? star.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", star=" + star +
                '}';
    }
}
