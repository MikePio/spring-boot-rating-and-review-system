package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{ // Integer è utilizzato come tipo del campo identificatore (id) della classe Product
  
}
