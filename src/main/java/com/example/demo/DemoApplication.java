package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Account;
import com.example.demo.entities.Product;
import com.example.demo.entities.Review;
import com.example.demo.repositories.AccountRepo;
import com.example.demo.repositories.ProductRepo;
import com.example.demo.repositories.ReviewRepo;
import com.example.demo.services.AccountService;
import com.example.demo.services.ProductService;
import com.example.demo.services.ReviewService;

@SpringBootApplication(scanBasePackages = "com.example.demo") //! DEVE ESSERCI LO STESSO NOME DEL PACKAGE (in questo caso com.example.demo)
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private ReviewRepo reviewRepo;

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private ProductService productService;

	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// inserisci gli oggetti/ i dati di prova da inserire nel db
		// Account account = new Account();
		// account.setUsername("johndoe");
		// account.setPassword("password");

		// Product product = new Product();
		// product.setName("The Lord of the Rings");

		// Review review = new Review();
		// review.setContent("The book was amazing! I really enjoyed it.");
		// review.setDatePost(new Date());
		// review.setRating(5.0f);
		// review.setAccount(account);
		// review.setProduct(product);

		// // Salva la recensione nel database
		// reviewRepo.save(review);
		
	}

}
