package com.bank.transfer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.transfer.entity.Payment;

@Service
public interface TransferService {

	List<Payment> getTransferDetails(Long accNo);

}
