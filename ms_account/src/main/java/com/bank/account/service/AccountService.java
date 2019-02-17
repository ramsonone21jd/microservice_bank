package com.bank.account.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.bank.account.dto.AccountDTO;
import com.bank.account.entity.Account;

@Service
public interface AccountService {

	public Long generateAccNo();

	public AccountDTO updateAccount(Account account);

	public AccountDTO getAccount(Long accNo);

	public AccountDTO updateBalance(Long accNo, BigDecimal balance);

	}
