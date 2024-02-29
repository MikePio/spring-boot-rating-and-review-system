package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;
import com.example.demo.repositories.AccountRepo;
import com.example.demo.repositories.ReviewRepo;

@Service
public class AccountService {
  
  @Autowired
  private AccountRepo accountRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;
  
	// * per la registrazione
  // public void save(Account account) {
	// 	accountRepo.save(account);
	// }
	// metodo save modificato in modo da far ritornare l'oggetto account
	// public Account save(Account account) {
	// 	return accountRepo.save(account);
	// } 
	// * metodo save usando PasswordEncoder.encode di Spring Security 
	public Account save(Account account) {
		// Codifica la password prima di salvarla nel database
		String encodedPassword = passwordEncoder.encode(account.getPassword());

		account.setPassword(encodedPassword);
		
		return accountRepo.save(account);
	}

	// * per il login
	public Account findByUsername(String username) {
		return accountRepo.findByUsername(username);
	}
  
}
