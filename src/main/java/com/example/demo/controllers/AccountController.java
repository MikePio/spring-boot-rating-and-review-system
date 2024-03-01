package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Account;
import com.example.demo.services.AccountService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("account") //! http://localhost:8080/account
public class AccountController {

  @Autowired
  private AccountService accountService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @GetMapping("/login") //! http://localhost:8080/account/login
  public String login(Model model){

    // Aggiungi un account vuoto al modello per il form di login
    model.addAttribute("account", new Account());

    return "account-login";
  }

  @GetMapping("/registration") //! http://localhost:8080/account/registration
  public String registration(Model model){
    // Aggiungi un account vuoto al modello per il form di registrazione
    model.addAttribute("account", new Account());
    return "account-registration";
  }

  @PostMapping("/login") //! http://localhost:8080/account/login
  public String login(@ModelAttribute("account") Account account, HttpSession session) {
  // STESSA COSA DI:
  // public String login(@RequestParam String username, @RequestParam String password) {

    // Cerca l'account nel database utilizzando il nome utente
    Account existingAccount = accountService.findByUsername(account.getUsername());

    // Controlla se l'account esiste e se la password inserita corrisponde a quella memorizzata nel database
    // ! SICCOME LA PASSWORD è CRIPTATA SI UTILIZZA matches PER VERIFICARE SE è UGUALE O MENO (E NON equals)
    if (existingAccount != null && passwordEncoder.matches(account.getPassword(), existingAccount.getPassword())) {
      // Login riuscito
      // aggiungo l'attributo username alla sessione
      session.setAttribute("username", account.getUsername());
      return "redirect:/products";
    } else {
      // Login fallito, reindirizza al form di login con un messaggio di errore
      return "redirect:/account/login?error";
    }

  }

  @PostMapping("/registration") //! http://localhost:8080/account/registration
  public String registration(@ModelAttribute Account account, BindingResult bindingResult, Model model, HttpSession session) {
    // Validazione di ogni campo
    if (account.getFullName() == null || account.getFullName().length() < 2) {
      // Aggiunge un errore al risultato di binding indicando che il campo "fullName" di "account" ha un dato inserito errato
      bindingResult.addError(new FieldError("account", "fullName", "Full name is required and must be at least 2 characters long."));
    }
    if (account.getUsername().contains(" ")) {
      bindingResult.addError(new FieldError("account", "username", "Username cannot contain spaces."));
    }
    if (accountService.findByUsername(account.getUsername()) != null) {
      bindingResult.addError(new FieldError("account", "username", "Username already exists. Please choose a unique username."));
    }
    if (account.getUsername() == null || account.getUsername().isEmpty()) {
      bindingResult.addError(new FieldError("account", "username", "Username is required."));
    }

    // salva se non ci sono errori
    if (!bindingResult.hasErrors()) {
      // aggiungo l'attributo username alla sessione
      session.setAttribute("username", account.getUsername());
      accountService.save(account);
      return "redirect:/products"; 
    }

    // se ci sono errori, aggiungi gli errori al modello per la visualizzazione nella vista
    model.addAttribute("errors", bindingResult.getAllErrors());
    return "account-registration"; // Visualizza nuovamente il form di registrazione
  
  }
  
  // andando sull'url "http://localhost:8080/account/logout" (cioè cliccando sul link logout) viene rimosso l'attributo username dalla sessione
  @GetMapping("/logout")
  public String logout(HttpSession session) {
    session.removeAttribute("username");
    return "redirect:/products"; 
  }

}
