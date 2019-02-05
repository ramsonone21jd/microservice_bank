package com.bank.beneficiary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.beneficiary.entity.Beneficiary;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long>{

	@Query("SELECT b from Beneficiary b where b.accNo = :accNo")
	List<Beneficiary> getBensForAccount(@Param("accNo") Long accNo);

}
