package com.bank.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.account.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query("SELECT a.accNo from Account a")
	 public List<Long> getAllAccountList();

	//public Account save(Account account);
	//public List<Account> findAll();
	//public Account findOne(Long id);
}
