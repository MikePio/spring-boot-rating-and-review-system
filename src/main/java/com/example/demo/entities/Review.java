package com.example.demo.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "review")
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  private String content;
  private Date datePost;
  private float rating;

  // * per ogni recensione esiste un solo account cioè la stessa recensione non può essere assegnata ad un altro account
  @ManyToOne // * oppure @ManyToOne(fetch = FetchType.EAGER)  ---->  Se `fetch = FetchType.EAGER`, la relazione tra le due entità verrà caricata sempre, anche se non è necessario l'accesso
  // * invece
  // @ManyToOne(fetch = FetchType.LAZY)  // * Se `fetch = FetchType.LAZY`, la relazione tra le due entità verrà caricata solo quando ne sarà necessario l'accesso
  @JoinColumn(name = "account_id", nullable = false) // oppure @JoinColumn(nullable = false) // * una recensione non può esistere senza un account 
  @JsonBackReference // * Viene utilizzata sul lato "inverso" della relazione bidirezionale cioè non serializzare l'oggetto referenziato
  private Account account;

  // * per ogni recensione esiste un solo prodotto cioè la stessa recensione non può essere assegnata ad un altro prodotto
  @ManyToOne  // * oppure @ManyToOne(fetch = FetchType.EAGER)  ---->  Se `fetch = FetchType.EAGER`, la relazione tra le due entità verrà caricata sempre, anche se non è necessario l'accesso
  // * invece
  // @ManyToOne(fetch = FetchType.LAZY)  // * Se `fetch = FetchType.LAZY`, la relazione tra le due entità verrà caricata solo quando ne sarà necessario l'accesso
  @JoinColumn(name = "product_id", nullable = false) // oppure @JoinColumn(nullable = false) // * una recensione non può esistere senza un prodotto 
  @JsonBackReference // * Viene utilizzata sul lato "inverso" della relazione bidirezionale cioè non serializzare l'oggetto referenziato
  private Product product;

  public Review() {}

  public Review(String content, Date datePost, float rating, Account account, Product product) {
    this.content = content;
    this.datePost = datePost;
    this.rating = rating;
    this.account = account;
    this.product = product;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getDatePost() {
    return datePost;
  }

  public void setDatePost(Date datePost) {
    this.datePost = datePost;
  }

  public float getRating() {
    return rating;
  }

  public void setRating(float rating) {
    this.rating = rating;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  @Override
  public String toString() {
    return "Review [id=" + id + ", content=" + content + ", datePost=" + datePost + ", rating=" + rating + ", account="
        + account + ", product=" + product + "]";
  }

}