package com.bank.account.service;

import org.springframework.stereotype.Service;

import com.bank.account.dto.AccountDTO;
import com.bank.account.entity.Account;

@Service
public interface AccountService {

	public Long generateAccNo();

	public AccountDTO updateAccount(Account account);

	}
