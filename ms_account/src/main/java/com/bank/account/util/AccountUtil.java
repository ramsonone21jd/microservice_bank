package com.bank.account.util;

import com.bank.account.dto.AccountDTO;
import com.bank.account.entity.Account;

public class AccountUtil {

	public static AccountDTO getAccoutDTO(Account acc) {
		AccountDTO dto = new AccountDTO();
		dto.setAccId(acc.getAccId());
		dto.setAccNo(acc.getAccNo());
		dto.setBalance(acc.getBalance());
		dto.setCity(acc.getCity());
		dto.setIdProof(acc.getIdProof());
		dto.setName(acc.getName());
		return dto;
	}

}
