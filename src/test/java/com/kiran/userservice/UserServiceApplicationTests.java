package com.kiran.userservice;

import com.kiran.userservice.external.RatingService;
import com.kiran.userservice.payload.Rating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;


@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private RatingService ratingService;
	@Test
	void contextLoads() {
	}

	@Test
   public void createRating(){
	   Rating build = Rating.builder().ratingId("").userId("").ratings(5).feedback("feign client!!").build();
	   Rating rating = ratingService.createRating(build);
       System.out.println("executed!!!!!");

   }
}
