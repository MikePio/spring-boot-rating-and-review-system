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

		// Product product = new Product();
		// product.setName("The Lord of the Rings");
		// product.setPrice(10.5);
		// product.setImage("https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_.jpg");

		// Review review = new Review();
		// review.setContent("The book was amazing! I really enjoyed it.");
		// review.setDatePost(new Date());
		// review.setRating(5.0f);
		// review.setAccount(account);
		// review.setProduct(product);

		// Salva l'account nel database
		accountService.save(account);
		System.out.println("!!account!! " + account);
		// // Salva il product nel database
		// productService.save(product);
		// System.out.println("!!product!! " + product);
		// // Salva la recensione nel database
		// reviewService.save(review);
		// System.out.println("!!review!! " + review);

		// Altri 3 nuovi oggetti
		Account account2 = new Account();
		account2.setUsername("Mario125");
		account2.setPassword("securepassword");

		// Product product2 = new Product();
		// product2.setName("Harry Potter and the Philosopher's Stone");
		// product2.setPrice(12.99);
		// product2.setImage("https://m.media-amazon.com/images/I/51UoqRAxwEL._SY346_.jpg");

		// Review review2 = new Review();
		// review2.setContent("This book is a classic! I couldn't put it down.");
		// review2.setDatePost(new Date());
		// review2.setRating(4.5f);
		// review2.setAccount(account2);
		// review2.setProduct(product2);

		// Salva l'account nel database
		accountService.save(account2);
		// System.out.println("!!account!! " + account2);
		// // Salva il product nel database
		// productService.save(product2);
		// System.out.println("!!product!! " + product2);
		// // Salva la recensione nel database
		// reviewService.save(review2);
		// System.out.println("!!review!! " + review2);


		// Altra nuova review
		// Review review3 = new Review();
		// review3.setContent("I liked it!");
		// review3.setDatePost(new Date());
		// review3.setRating(4f);
		// review3.setAccount(account);
		// review3.setProduct(product2);

		// Salva la recensione nel database
		// reviewService.save(review3);
		// System.out.println("!!review!! " + review3);

		// nuovo utente
		Account account3 = new Account();
		account3.setUsername("asd");
		account3.setPassword("123");
		
		accountService.save(account3);
		System.out.println("!!account!! " + account3);


		// altri prodotti
		Product gtaV = new Product();
		gtaV.setName("Grand Theft Auto V");
		gtaV.setPrice(29.99);
		gtaV.setImage("https://images6.alphacoders.com/438/438835.jpg"); // URL dell'immagine del videogioco

		// Creazione delle recensioni
		Product godOfWarRagnarok = new Product();
		godOfWarRagnarok.setName("God of War Ragnarok");
		godOfWarRagnarok.setPrice(59.99);
		godOfWarRagnarok.setImage("https://image.api.playstation.com/vulcan/ap/rnd/202109/2821/SZRc7OMwGgv8lJXIOlYyuBU2.jpg"); // URL dell'immagine del videogioco

		Review reviewGodOfWarRagnarok = new Review();
		reviewGodOfWarRagnarok.setContent("A masterpiece of storytelling and gameplay! The God of War series continues to impress with Ragnarok.");
		reviewGodOfWarRagnarok.setDatePost(new Date());
		reviewGodOfWarRagnarok.setRating(5.0f);
		reviewGodOfWarRagnarok.setAccount(account);
		reviewGodOfWarRagnarok.setProduct(godOfWarRagnarok);

		productService.save(godOfWarRagnarok);
		reviewService.save(reviewGodOfWarRagnarok);

		Product theLastOfUs = new Product();
		theLastOfUs.setName("The Last of Us");
		theLastOfUs.setPrice(29.99);
		theLastOfUs.setImage("https://static.posters.cz/image/750/posters/the-last-of-us-key-art-i127761.jpg"); // URL dell'immagine del videogioco

		productService.save(theLastOfUs);
		
		Review gtaVReview1 = new Review();
		gtaVReview1.setContent("GTA V è un gioco incredibile. La mappa vasta, le missioni variegate e il multiplayer rendono questo gioco un must-have per tutti i giocatori.");
		gtaVReview1.setDatePost(new Date());
		gtaVReview1.setRating(4.7f);
		gtaVReview1.setAccount(account3);
		gtaVReview1.setProduct(gtaV);

		Review gtaVReview2 = new Review();
		gtaVReview2.setContent("Ho giocato a GTA V per anni e ancora non mi stanco. La modalità storia è coinvolgente e il multiplayer offre infinite possibilità di divertimento.");
		gtaVReview2.setDatePost(new Date());
		gtaVReview2.setRating(4.9f);
		gtaVReview2.setAccount(account2);
		gtaVReview2.setProduct(gtaV);

		productService.save(gtaV);
		reviewService.save(gtaVReview1);
		reviewService.save(gtaVReview2);

		Product godOfWar = new Product();
		godOfWar.setName("God of War");
		godOfWar.setPrice(39.99);
		godOfWar.setImage("https://image.api.playstation.com/vulcan/img/rnd/202010/2217/p3pYq0QxntZQREXRVdAzmn1w.png"); // URL dell'immagine del videogioco
		
		// Creazione delle recensioni
		Review godOfWarReview1 = new Review();
		godOfWarReview1.setContent("God of War è un capolavoro assoluto. La storia, i personaggi, il combattimento - tutto è fenomenale.");
		godOfWarReview1.setDatePost(new Date());
		godOfWarReview1.setRating(5.0f);
		godOfWarReview1.setAccount(account); // Account dell'utente che ha scritto la recensione
		godOfWarReview1.setProduct(godOfWar); // Il prodotto a cui si riferisce la recensione

		Review godOfWarReview2 = new Review();
		godOfWarReview2.setContent("Uno dei migliori giochi che abbia mai giocato. L'ambientazione nordica è meravigliosa e la grafica è incredibile.");
		godOfWarReview2.setDatePost(new Date());
		godOfWarReview2.setRating(4.8f);
		godOfWarReview2.setAccount(account2);
		godOfWarReview2.setProduct(godOfWar);

		productService.save(godOfWar);
		reviewService.save(godOfWarReview1);
		reviewService.save(godOfWarReview2);

		Product narutoStorm4 = new Product();
		narutoStorm4.setName("Naruto Shippuden: Ultimate Ninja Storm 4");
		narutoStorm4.setPrice(19.99);
		narutoStorm4.setImage("https://fin.co.id/upload/338b6928759ca65c8502ce224ea9ccea.jpg"); // URL dell'immagine del videogioco

		// Creazione delle recensioni
		Review narutoStorm4Review1 = new Review();
		narutoStorm4Review1.setContent("Sono un grande fan di Naruto e questo gioco è semplicemente fantastico. La grafica è incredibile e i combattimenti sono intensi.");
		narutoStorm4Review1.setDatePost(new Date());
		narutoStorm4Review1.setRating(4.5f);
		narutoStorm4Review1.setAccount(account);
		narutoStorm4Review1.setProduct(narutoStorm4);

		Review narutoStorm4Review2 = new Review();
		narutoStorm4Review2.setContent("Un gioco di combattimento eccellente che cattura perfettamente l'essenza di Naruto. I combattimenti sono fluidi e la grafica è mozzafiato.");
		narutoStorm4Review2.setDatePost(new Date());
		narutoStorm4Review2.setRating(4.3f);
		narutoStorm4Review2.setAccount(account3);
		narutoStorm4Review2.setProduct(narutoStorm4);

		productService.save(narutoStorm4);
		reviewService.save(narutoStorm4Review1);
		reviewService.save(narutoStorm4Review2);

		Product redDeadRedemption2 = new Product();
		redDeadRedemption2.setName("Red Dead Redemption 2");
		redDeadRedemption2.setPrice(49.99);
		redDeadRedemption2.setImage("https://image.api.playstation.com/cdn/UP1004/CUSA03041_00/Hpl5MtwQgOVF9vJqlfui6SDB5Jl4oBSq.png"); // URL dell'immagine del videogioco

		Review reviewRedDeadRedemption2 = new Review();
		reviewRedDeadRedemption2.setContent("A breathtaking open-world experience with captivating storytelling and immersive gameplay.");
		reviewRedDeadRedemption2.setDatePost(new Date());
		reviewRedDeadRedemption2.setRating(5.0f);
		reviewRedDeadRedemption2.setAccount(account);
		reviewRedDeadRedemption2.setProduct(redDeadRedemption2);

		productService.save(redDeadRedemption2);
		reviewService.save(reviewRedDeadRedemption2);

		// FILM
		Product johnWick4 = new Product();
		johnWick4.setName("John Wick 4");
		johnWick4.setPrice(14.99);
		johnWick4.setImage("https://m.media-amazon.com/images/M/MV5BMDExZGMyOTMtMDgyYi00NGIwLWJhMTEtOTdkZGFjNmZiMTEwXkEyXkFqcGdeQXVyMjM4NTM5NDY@._V1_.jpg"); // URL dell'immagine del film

		Review reviewJohnWick4 = new Review();
		reviewJohnWick4.setContent("Another thrilling installment in the John Wick series!");
		reviewJohnWick4.setDatePost(new Date());
		reviewJohnWick4.setRating(4.8f);
		reviewJohnWick4.setAccount(account);
		reviewJohnWick4.setProduct(johnWick4);

		productService.save(johnWick4);
		reviewService.save(reviewJohnWick4);

		Product avengersEndgame = new Product();
		avengersEndgame.setName("Avengers: Endgame");
		avengersEndgame.setPrice(19.99);
		avengersEndgame.setImage("https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_.jpg"); // URL dell'immagine del film
		
		Review reviewAvengersEndgame = new Review();
		reviewAvengersEndgame.setContent("A thrilling conclusion to the Marvel Cinematic Universe's Infinity Saga!");
		reviewAvengersEndgame.setDatePost(new Date());
		reviewAvengersEndgame.setRating(4.9f);
		reviewAvengersEndgame.setAccount(account);
		reviewAvengersEndgame.setProduct(avengersEndgame);

		productService.save(avengersEndgame);
		reviewService.save(reviewAvengersEndgame);
	
		Product ironMan3 = new Product();
		ironMan3.setName("Iron Man 3");
		ironMan3.setPrice(12.99);
		ironMan3.setImage("https://m.media-amazon.com/images/M/MV5BMjE5MzcyNjk1M15BMl5BanBnXkFtZTcwMjQ4MjcxOQ@@._V1_.jpg"); // URL dell'immagine del film
		
		Review reviewIronMan3 = new Review();
		reviewIronMan3.setContent("A thrilling addition to the Iron Man series, with great action and humor!");
		reviewIronMan3.setDatePost(new Date());
		reviewIronMan3.setRating(4.5f);
		reviewIronMan3.setAccount(account);
		reviewIronMan3.setProduct(ironMan3);
		
		productService.save(ironMan3);
		reviewService.save(reviewIronMan3);



	}

}
