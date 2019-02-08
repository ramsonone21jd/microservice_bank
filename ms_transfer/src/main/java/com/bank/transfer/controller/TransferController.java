package com.bank.transfer.controller;

import java.sql.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.transfer.entity.Payment;
import com.bank.transfer.repository.TransferRepository;
import com.bank.transfer.service.TransferService;

@RestController
@RequestMapping(value="/transfer")
public class TransferController {
	
	@Autowired
	private TransferRepository transferRepository;
	
	@Autowired
	@Qualifier(value="transferService")
	private TransferService transferService;
	
	@RequestMapping(value="/initiateTransfer", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON)
	public Payment create(@RequestBody Payment payment) {
		payment.setPaymentDate(new Date(System.currentTimeMillis()));
		return transferRepository.save(payment);
	}
	
	@RequestMapping(value="/getTransferDetails/{accNo}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public List<Payment> getAccount(@PathVariable("accNo") Long accNo) {
		return transferService.getTransferDetails(accNo);
	}
	
	@RequestMapping(value="/getAllBeneficiaries", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public List<Payment> getAllAccount() {
		return transferRepository.findAll();
	}

}
