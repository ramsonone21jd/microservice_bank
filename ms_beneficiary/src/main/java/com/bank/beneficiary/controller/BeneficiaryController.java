package com.bank.beneficiary.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.beneficiary.entity.Beneficiary;
import com.bank.beneficiary.repository.BeneficiaryRepository;
import com.bank.beneficiary.service.BeneficiaryService;

@RestController
@RequestMapping(value="beneficiary")
public class BeneficiaryController {
	
	@Autowired
	private BeneficiaryRepository beneficiaryRepository;
	
	@Autowired
	@Qualifier(value="beneficiaryService")
	private BeneficiaryService beneficiaryService;
	
	@RequestMapping(value="/createBeneficiary", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON)
	public Beneficiary create(@RequestBody Beneficiary ben) {
		return beneficiaryRepository.save(ben);
	}
	
	@RequestMapping(value="/getBeneficiaries/{accNo}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public List<Beneficiary> getAccount(@PathVariable("accNo") Long accNo) {
		return beneficiaryService.getBeneficiariesForAccount(accNo);
	}
	
	@RequestMapping(value="/getAllBeneficiaries", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public List<Beneficiary> getAllAccount() {
		return beneficiaryRepository.findAll();
	}

}
