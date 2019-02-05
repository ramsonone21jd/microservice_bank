package com.bank.beneficiary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.beneficiary.entity.Beneficiary;
import com.bank.beneficiary.repository.BeneficiaryRepository;

@Service(value="beneficiaryService")
public class BeneficiaryServiceImpl implements BeneficiaryService {
	
	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	@Override
	public List<Beneficiary> getBeneficiariesForAccount(Long accNo) {
		List<Beneficiary> benList = beneficiaryRepository.getBensForAccount(accNo);
		return benList;
	}

}
