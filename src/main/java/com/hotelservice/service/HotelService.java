package com.hotelservice.service;

import com.hotelservice.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    Hotel getHotel(String hotelId);

    List<Hotel> getAllHotels();
}
