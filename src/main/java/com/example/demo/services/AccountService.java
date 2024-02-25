package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;
import com.example.demo.repositories.AccountRepo;
import com.example.demo.repositories.ReviewRepo;

@Service
public class AccountService {
  
  @Autowired
  private AccountRepo accountRepo;
  
  // public void save(Account account) {
	// 	accountRepo.save(account);
	// }
	// metodo save modificato in modo da far ritornare l'oggetto account
	public Account save(Account account) {
		return accountRepo.save(account);
	} 

  
}
