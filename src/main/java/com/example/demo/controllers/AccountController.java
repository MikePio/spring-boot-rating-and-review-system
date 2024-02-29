package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Account;
import com.example.demo.services.AccountService;

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
  public String login(@ModelAttribute("account") Account account) {
  // STESSA COSA DI:
  // public String login(@RequestParam String username, @RequestParam String password) {

    // Cerca l'account nel database utilizzando il nome utente
    Account existingAccount = accountService.findByUsername(account.getUsername());

    // Controlla se l'account esiste e se la password inserita corrisponde a quella memorizzata nel database
    // ! SICCOME LA PASSWORD è CRIPTATA SI UTILIZZA matches PER VERIFICARE SE è UGUALE O MENO (E NON equals)
    if (existingAccount != null && passwordEncoder.matches(account.getPassword(), existingAccount.getPassword())) {
      // Login riuscito
      return "redirect:/products";
    } else {
      // Login fallito, reindirizza al form di login con un messaggio di errore
      return "redirect:/account/login?error";
    }

  }

  @PostMapping("/registration") //! http://localhost:8080/account/registration
  public String registration(@ModelAttribute Account account, @RequestParam(required = true) String username, String password, @RequestParam(required = true) String fullName) {
    
    accountService.save(account);

    return "redirect:/products";
  
  }


}
