package com.bank.transfer.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.transfer.dto.PaymentDTO;
import com.bank.transfer.entity.Payment;
import com.bank.transfer.service.TransferService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value="/transfer")
public class TransferController {
	
	@Autowired
	@Qualifier(value="transferService")
	private TransferService transferService;
	
	@RequestMapping(value="/initiateTransfer", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON)
	public ResponseEntity<PaymentDTO>  create(@RequestBody Payment payment) {
		 PaymentDTO dto =transferService.intiateTransfer(payment);
		 ResponseEntity<PaymentDTO> entity ;
		 if (dto.getErrorMsg()!=null) {
			 return new ResponseEntity<PaymentDTO>(HttpStatus.BAD_REQUEST);
		 }
		 return new ResponseEntity<PaymentDTO>(dto,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getTransferDetails/{accNo}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public List<PaymentDTO> getAccount(@PathVariable("accNo") Long accNo) {
		return transferService.getTransferDetails(accNo);
	}
	
	@RequestMapping(value="/getAllTransfers", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public List<PaymentDTO> getAllTransfers() {
		return transferService.getAllTransfers();
	}

}
