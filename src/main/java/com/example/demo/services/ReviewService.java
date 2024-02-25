package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;
import com.example.demo.entities.Review;
import com.example.demo.repositories.ReviewRepo;

@Service
public class ReviewService {
  
  @Autowired
  private ReviewRepo reviewRepo;

  // public void save(Review review) {
	// 	reviewRepo.save(review);
	// }
	// metodo save modificato in modo da far ritornare l'oggetto review
	public Review save(Review review) {
		return reviewRepo.save(review);
	} 
  
}
