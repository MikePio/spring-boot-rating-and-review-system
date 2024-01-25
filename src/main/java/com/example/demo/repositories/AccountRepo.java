package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer>{ // Integer è utilizzato come tipo del campo identificatore (id) della classe Account
  
}
