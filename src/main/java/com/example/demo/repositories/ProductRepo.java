package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{ // Integer è utilizzato come tipo del campo identificatore (id) della classe Product
  
  
  // * trova il nome del prodotto con le lettere che sono incluse nel nome della pizza (parola cercata: "vola" trovata la pizza "diavola")
  // * questo è uno dei metodi offerti da data jpa per eseguire una query
  public List<Product> findByNameContainingIgnoreCase(String str);
  // OPPURE
  // public List<Product> findByNameContaining(String str);
  // OPPURE METODO 2 // \ Usando una query JPQL
  // @Query("SELECT p FROM Product p WHERE p.name LIKE :name")
  // List<Product> findByName(@Param("name") String name);
}
