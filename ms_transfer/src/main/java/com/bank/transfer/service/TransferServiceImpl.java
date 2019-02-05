package com.bank.transfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.transfer.entity.Payment;
import com.bank.transfer.repository.TransferRepository;

@Service(value="transferService")
public class TransferServiceImpl implements TransferService {
	
	@Autowired
	private TransferRepository transferRepository;

	@Override
	public List<Payment> getTransferDetails(Long accNo) {		
		return transferRepository.getTransferDetails(accNo);
	}

}
