package com.bank.account.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.account.dto.AccountDTO;
import com.bank.account.entity.Account;
import com.bank.account.repository.AccountRepository;
import com.bank.account.util.AccountUtil;

@Service(value="accountService")
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	private Long getNewAccountNumber() {
		long leftLimit = 999999L;
	    long rightLimit = 9999999L;
	    long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
	    return generatedLong;
	}
	
	@Transactional
	public Long generateAccNo() {
		Long accNo = 0L;
		List<Long> accList = accountRepository.getAllAccountList();
		do {
			accNo = getNewAccountNumber();
		}while(accList.contains(accNo));
		
		return accNo;
	}

	@Override
	public AccountDTO updateAccount(Account account) {
		Account acc = accountRepository.save(account);
		return AccountUtil.getAccoutDTO(acc);
	}

	@Override
	public AccountDTO getAccount(Long accNo) {
		Account account = accountRepository.getAccount(accNo);
		return AccountUtil.getAccoutDTO(account);
	}

	@Override
	public AccountDTO updateBalance(Long accNo, BigDecimal balance) {
		accountRepository.updateBalance(accNo,balance);
		return getAccount(accNo);
	}

}
