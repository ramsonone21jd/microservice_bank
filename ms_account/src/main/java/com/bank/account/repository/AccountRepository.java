package com.bank.account.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.account.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query("SELECT a.accNo from Account a")
	public List<Long> getAllAccountList();

	@Query("SELECT a from Account a where a.accNo=:accNo")
	public Account getAccount(@Param("accNo") Long accNo);

	@Query("update Account a set a.balance=:balance where a.accNo=:accNo")
	public void updateBalance(@Param("accNo") Long accNo,@Param("balance") BigDecimal balance);
	
}
