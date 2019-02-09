package com.bank.transfer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.transfer.dto.PaymentDTO;
import com.bank.transfer.entity.Payment;

@Service
public interface TransferService {

	List<PaymentDTO> getTransferDetails(Long accNo);

	PaymentDTO intiateTransfer(Payment payment);

	List<PaymentDTO> getAllTransfers();

}
