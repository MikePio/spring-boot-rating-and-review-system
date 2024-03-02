package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> { // Integer è utilizzato come tipo del campo identificatore (id) della classe Review
  
  List<Review> findByProductId(int productId);
}
