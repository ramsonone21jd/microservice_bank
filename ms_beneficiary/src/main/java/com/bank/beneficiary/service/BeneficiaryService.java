package com.bank.beneficiary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.beneficiary.entity.Beneficiary;

@Service
public interface BeneficiaryService {

	List<Beneficiary> getBeneficiariesForAccount(Long accNo);

}
