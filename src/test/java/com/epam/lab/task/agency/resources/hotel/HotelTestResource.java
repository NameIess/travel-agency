package com.epam.lab.task.agency.resources.hotel;

import com.epam.lab.task.agency.entity.Hotel;
import com.epam.lab.task.agency.repository.specification.impl.HotelSpecificationById;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class HotelTestResource {
    public static final HotelSpecificationById INVALID_HOTEL_SPECIFICATION_BY_ID_1 = new HotelSpecificationById(2345L);
    public static final HotelSpecificationById INVALID_HOTEL_SPECIFICATION_BY_ID_2 = new HotelSpecificationById(999L);
    public static final HotelSpecificationById INVALID_HOTEL_SPECIFICATION_BY_ID_3 = new HotelSpecificationById(4564575L);
    public static final Optional<Hotel> EMPTY_OPTIONAL_HOTEL = Optional.empty();
    public static final Optional<Collection<Hotel>> EMPTY_OPTIONAL_HOTEL_COLLECTION = Optional.empty();

    private static Hotel createHotel(long id, String name, String phone, Byte star) {
        Hotel hotel = new Hotel();
        hotel.setId(id);
        hotel.setName(name);
        hotel.setPhone(phone);
        hotel.setStar(star);
        return hotel;
    }

    public static Optional<Collection<Hotel>> getOptionalHotelCollection() {
        return Optional.of(getHotelCollection());
    }

    public static Collection<Hotel> getHotelCollection() {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(getValidHotel1());
        hotels.add(getValidHotel2());
        hotels.add(getValidHotel3());
        return hotels;
    }

    public static Optional<Hotel> getOptionalHotel1() {
        return Optional.of(getValidHotel1());
    }

    public static Optional<Hotel> getOptionalHotel2() {
        return Optional.of(getValidHotel2());
    }

    public static Optional<Hotel> getOptionalHotel3() {
        return Optional.of(getValidHotel3());
    }

    public static HotelSpecificationById getHotelSpecificationById1() {
        return new HotelSpecificationById(getValidHotel1().getId());
    }

    public static HotelSpecificationById getHotelSpecificationById2() {
        return new HotelSpecificationById(getValidHotel2().getId());
    }

    public static HotelSpecificationById getHotelSpecificationById3() {
        return new HotelSpecificationById(getValidHotel3().getId());
    }

    public static Hotel getValidHotel1() {
        return createHotel(1L, "Grand Budapest", "8-800-555-35-35", Byte.valueOf("5"));
    }

    public static Hotel getValidHotel2() {
        return createHotel(2L, "Grand Theft Auto", "+257 453 296 1", Byte.valueOf("4"));
    }

    public static Hotel getValidHotel3() {
        return createHotel(3L, "House and sons", "937 99 92", Byte.valueOf("3"));
    }
}
