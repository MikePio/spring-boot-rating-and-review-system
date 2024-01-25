package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  private String username;
  private String password;
  private String fullName;

  @OneToMany(mappedBy = "account") // oppure @OneToMany(mappedBy = "product", fetch = FetchType.EAGER) // *  Se `fetch = FetchType.EAGER`, la relazione tra le due entità verrà caricata sempre, anche se non è necessario l'accesso
  // @OneToMany(mappedBy = "product", fetch = FetchType.LAZY) // * Se `fetch = FetchType.LAZY`, la relazione tra le due entità verrà caricata solo quando ne sarà necessario l'accesso (sarebbe più complesso fare operazioni CRUD)
  @JsonManagedReference // * Viene utilizzata sul lato "proprietario" della relazione bidirezionale cioè serializzare l'oggetto referenziato
  private Set<Review> reviews = new HashSet<>(0); // Se non avessi messo lo 0, il set reviews sarebbe stato creato con una capacità iniziale predefinita. Per un set HashSet, la capacità predefinita è 16. Questo significa che il set occuperebbe 16 elementi di memoria al momento della sua creazione, anche se inizialmente non contiene alcun elemento.
  
  public Account(){}
  
  public Account(String username, String password, String fullName) {

    setUsername(username);
    setPassword(password);
    setFullName(fullName);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Set<Review> getReviews() {
    return reviews;
  }

  public void setReviews(Set<Review> reviews) {
    this.reviews = reviews;
  }

  @Override
  public String toString() {
    return "Account [id=" + getId() + ", username=" + getUsername() + ", password=" + getPassword() + ", fullName=" + getFullName()
        + ", reviews=" + getReviews() + "]";
  }

  



  
}
