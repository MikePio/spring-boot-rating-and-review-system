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
		Account account = new Account();
		account.setUsername("johndoe");
		account.setPassword("password");

		Product product = new Product();
		product.setName("The Lord of the Rings");
		product.setPrice(10.5);
		product.setImage("https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_.jpg");

		Review review = new Review();
		review.setContent("The book was amazing! I really enjoyed it.");
		review.setDatePost(new Date());
		review.setRating(5.0f);
		review.setAccount(account);
		review.setProduct(product);

		// Salva l'account nel database
		accountService.save(account);
		System.out.println("!!account!! " + account);
		// Salva il product nel database
		productService.save(product);
		System.out.println("!!product!! " + product);
		// Salva la recensione nel database
		reviewService.save(review);
		System.out.println("!!review!! " + review);

		// Altri 3 nuovi oggetti
		Account account2 = new Account();
		account2.setUsername("Mario125");
		account2.setPassword("securepassword");

		Product product2 = new Product();
		product2.setName("Harry Potter and the Philosopher's Stone");
		product2.setPrice(12.99);
		product2.setImage("https://m.media-amazon.com/images/I/51UoqRAxwEL._SY346_.jpg");

		Review review2 = new Review();
		review2.setContent("This book is a classic! I couldn't put it down.");
		review2.setDatePost(new Date());
		review2.setRating(4.5f);
		review2.setAccount(account2);
		review2.setProduct(product2);

		// Salva l'account nel database
		accountService.save(account2);
		System.out.println("!!account!! " + account2);
		// Salva il product nel database
		productService.save(product2);
		System.out.println("!!product!! " + product2);
		// Salva la recensione nel database
		reviewService.save(review2);
		System.out.println("!!review!! " + review2);


		// Altra nuova review
		Review review3 = new Review();
		review3.setContent("I liked it!");
		review3.setDatePost(new Date());
		review3.setRating(4f);
		review3.setAccount(account);
		review3.setProduct(product2);

		// Salva la recensione nel database
		reviewService.save(review3);
		System.out.println("!!review!! " + review3);

	}

}
