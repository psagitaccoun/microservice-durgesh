package com.kiran.userservice.service.impl;

import com.kiran.userservice.entity.User;
import com.kiran.userservice.exception.ResourceNotFoundException;
import com.kiran.userservice.external.HotelService;
import com.kiran.userservice.external.RatingService;
import com.kiran.userservice.payload.Hotel;
import com.kiran.userservice.payload.Rating;
import com.kiran.userservice.repository.UserRepository;
import com.kiran.userservice.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RatingService ratingService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        String response = UUID.randomUUID().toString();
        user.setUId(response);
        User save = userRepository.save(user);
        return save;
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found in server!!" + userId)
        );
      //  Rating[] forObject = restTemplate.getForObject("http://RATING-SERVER/ratings/user/" + userId, Rating[].class);
      //  List<Rating> list = Arrays.stream(forObject).toList();
        List<Rating> list = ratingService.getRatingsByUserId(userId);

        list.stream().map(rating->{
            //call hotel api
           // Hotel forObject1 = restTemplate.getForObject("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
                   return rating;
        }).collect(Collectors.toList());

     user.setRating(list);
        return user;
    }


}
