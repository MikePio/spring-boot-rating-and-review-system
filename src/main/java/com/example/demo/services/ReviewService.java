package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Review;
import com.example.demo.repositories.ReviewRepo;

@Service
public class ReviewService {
  
  @Autowired
  private ReviewRepo reviewRepo;


}
