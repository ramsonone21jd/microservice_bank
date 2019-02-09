package com.bank.transfer.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bank.transfer.dto.PaymentDTO;
import com.bank.transfer.entity.Account;
import com.bank.transfer.entity.Payment;
import com.bank.transfer.repository.TransferRepository;
import com.bank.transfer.util.TransferUtil;

@Service(value="transferService")
public class TransferServiceImpl implements TransferService {
	
	@Autowired
	private TransferRepository transferRepository;
	
	RestTemplate restTemplate = new RestTemplate();

	@Transactional
	public List<PaymentDTO> getTransferDetails(Long accNo) {		
		List<Payment> payments = transferRepository.getTransferDetails(accNo);
        List<PaymentDTO> dtoList = new ArrayList<PaymentDTO>();
		
		for(Payment pmt : payments) {
			PaymentDTO dto = TransferUtil.getPaymentDTO(pmt);
			dtoList.add(dto);
		}		
		return dtoList;
	}

	@Transactional
	public PaymentDTO intiateTransfer(Payment payment) {
		payment.setPaymentDate(new Date(System.currentTimeMillis()));
		 Account sourceAccount = restTemplate.getForObject(TransferUtil.GET_ACCOUNT+"/"+payment.getSourceAccount(), Account.class);
		 Account destAccount = restTemplate.getForObject(TransferUtil.GET_ACCOUNT+"/"+payment.getToAccountNo(), Account.class);
		 int comp = sourceAccount.getBalance().compareTo(payment.getAmount());
		 Payment pmt =null;
		 PaymentDTO dto = new PaymentDTO();
		 if(comp==0 || comp==1) {
			 sourceAccount.setBalance(sourceAccount.getBalance().subtract(payment.getAmount()));
			 destAccount.setBalance(destAccount.getBalance().add(payment.getAmount()));
			 HttpEntity<Account> sourceEntity = new HttpEntity<Account>(sourceAccount);
			 HttpEntity<Account> destEntity = new HttpEntity<Account>(destAccount);			 
			 Account srcAcc = restTemplate.postForObject(TransferUtil.UPDATE_ACCOUNT, sourceEntity, Account.class);
			 Account destAcc = restTemplate.postForObject(TransferUtil.UPDATE_ACCOUNT, destEntity, Account.class);
			 pmt = transferRepository.save(payment);
		 }else {
			 dto.setErrorMsg(TransferUtil.INSUFFICIENT_FUND);
		 }
		 return TransferUtil.getPaymentDTO(pmt,dto);
	}

	@Transactional
	public List<PaymentDTO> getAllTransfers() {
		List<Payment> payments = transferRepository.findAll();
		List<PaymentDTO> dtoList = new ArrayList<PaymentDTO>();
		
		for(Payment pmt : payments) {
			PaymentDTO dto = TransferUtil.getPaymentDTO(pmt);
			dtoList.add(dto);
		}		
		return dtoList;
	}

}
