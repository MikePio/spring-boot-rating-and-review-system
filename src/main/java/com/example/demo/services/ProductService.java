package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;
import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepo;
import com.example.demo.repositories.ReviewRepo;

@Service
public class ProductService {
  
  @Autowired
  private ProductRepo productRepo;

  // public void save(Product product) {
	// 	productRepo.save(product);
	// }
	// metodo save modificato in modo da far ritornare l'oggetto product
	public Product save(Product product) {
		return productRepo.save(product);
	} 



}
