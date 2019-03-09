package com.bank.account.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.account.dto.AccountDTO;
import com.bank.account.entity.Account;
import com.bank.account.repository.AccountRepository;
import com.bank.account.service.AccountService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@CrossOrigin()
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
	
	@HystrixCommand(fallbackMethod="getAccountFallBack")
	@RequestMapping(value="/getAccount/{accNo}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public AccountDTO getAccount(@PathVariable("accNo") Long accNo) {
		return accountService.getAccount(accNo);
	}
	
	public AccountDTO getAccountFallBack(Long accNo) {
		System.out.println("Inside fallback !!!");
		return new AccountDTO();
	}
	
	@RequestMapping(value="/getAllAccounts", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}
	
	@RequestMapping(value="/updateAccount", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON)
	public AccountDTO update(@RequestBody Account account) {
		return accountService.updateAccount(account);
	}
	
	@RequestMapping(value="/updateBalance/{accNO}/{balance}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON)
	public AccountDTO updateBalance(@PathVariable("accNo") Long accNo,@PathVariable("balance") BigDecimal balance) {
		return accountService.updateBalance(accNo,balance);
	}

}
