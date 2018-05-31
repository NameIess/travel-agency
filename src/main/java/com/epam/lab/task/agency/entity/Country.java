package com.epam.lab.task.agency.entity;

/**
 * Country domain entity.
 */
public class Country implements Identified<Long> {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;

    /**
     * Default constructor.
     */
    public Country() {
        // Instantiates country
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Country country = (Country) o;

        if (id != null ? !id.equals(country.id) : country.id != null) {
            return false;
        }
        return name != null ? name.equals(country.name) : country.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
