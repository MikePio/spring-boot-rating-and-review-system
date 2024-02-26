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
  
  public List<Product> findAll(){
    return productRepo.findAll();
  }
  // altro modo (nel video) ma restituisce solo un'interfaccia Iterable, non una List e potrebbe richiedere conversioni se si necessita di una List in particolare ed è più coerente con l'interfaccia CrudRepository
  // @Override
  // public Iterable<Product> findAll(){
  //   return productRepo.findAll();
  // }

  
  public List<Product> findByName(String str){

		// * trova il nome del prodotto con le lettere che sono incluse nel nome della pizza (parola cercata: "vola" trovata la pizza "diavola")
    return productRepo.findByNameContainingIgnoreCase(str);
    //* oppure si può inserire direttamente qui la logica della funzione che, in questo caso, è stata già inserita nel controller
		// if (str == null || str.isEmpty()) {
		// 		return productRepo.findAll();
		// } else {
		// 		return productRepo.findByNameContaining(str);
		// }
  }


  // Restituisce: Un oggetto Product se trovato, altrimenti lancia un'eccezione NoSuchElementException
	// public Product findById(int id) {
	// 	return productRepo.findById(id).get();
	// }
	// Restituisce: Un oggetto Optional<Product> contenente l'oggetto Product se trovato, altrimenti un Optional vuoto
	public Optional<Product> findById(int id) {
		return productRepo.findById(id);
	}
  // altro modo (nel video) 
  // @Override
  // public Product find(int id){
  //   return productRepo.findOne(id);
  // }

  // public void save(Product product) {
	// 	productRepo.save(product);
	// }
	// metodo save modificato in modo da far ritornare l'oggetto product
	public Product save(Product product) {
		return productRepo.save(product);
	} 



}
