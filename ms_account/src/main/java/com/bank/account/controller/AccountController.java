package com.bank.account.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.account.entity.Account;
import com.bank.account.repository.AccountRepository;
import com.bank.account.service.AccountService;

@RestController
@RequestMapping(value="/account")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	@Qualifier("accountService")
	private AccountService accountService;
	
	@RequestMapping(value="/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON)
	public Account create(@RequestBody Account account) {
		account.setAccNo(accountService.generateAccNo());
		return accountRepository.save(account);
	}
	
	@RequestMapping(value="/getAccount/{accId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public Account getAccount(@PathVariable("accId") Long accId) {
		return accountRepository.getOne(accId);
	}
	
	@RequestMapping(value="/getAllAccounts", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}

}
