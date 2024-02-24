package com.kiran.userservice.external;

import com.kiran.userservice.payload.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Service
@FeignClient(name="RATING-SERVER")
public interface RatingService {

    @GetMapping("/ratings/user/{userId}")
    public List<Rating> getRatingsByUserId(@PathVariable String userId);

    @PostMapping("/ratings")
    public Rating createRating(Rating rating);
}
