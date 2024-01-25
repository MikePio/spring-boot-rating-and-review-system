package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  private String name;
  private double price;
  private String image;

  @OneToMany(mappedBy = "product") // oppure @OneToMany(mappedBy = "product", fetch = FetchType.EAGER) // *  Se `fetch = FetchType.EAGER`, la relazione tra le due entità verrà caricata sempre, anche se non è necessario l'accesso
  // @OneToMany(mappedBy = "product", fetch = FetchType.LAZY) // * Se `fetch = FetchType.LAZY`, la relazione tra le due entità verrà caricata solo quando ne sarà necessario l'accesso (sarebbe più complesso fare operazioni CRUD)
  @JsonManagedReference // * Viene utilizzata sul lato "proprietario" della relazione bidirezionale cioè serializzare l'oggetto referenziato
  private Set<Review> reviews = new HashSet<>(0); // Se non avessi messo lo 0, il set reviews sarebbe stato creato con una capacità iniziale predefinita. Per un set HashSet, la capacità predefinita è 16. Questo significa che il set occuperebbe 16 elementi di memoria al momento della sua creazione, anche se inizialmente non contiene alcun elemento.

  public Product(){}

  public Product(String name, double price, String image){

    setName(name);
    setPrice(price);
    setImage(image);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Set<Review> getReviews() {
    return reviews;
  }

  public void setReviews(Set<Review> reviews) {
    this.reviews = reviews;
  }

  @Override
  public String toString() {
    return "Product [id=" + getId() + ", name=" + getName() + ", price=" + getPrice() + ", image=" + getImage() + ", reviews=" + getReviews()
        + "]";
  }


}
