package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.ProductRepo;
import com.example.demo.repositories.ReviewRepo;

@Service
public class ProductService {
  
  @Autowired
  private ProductRepo productRepo;

}
