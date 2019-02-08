package com.bank.transfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.transfer.entity.Payment;

@Repository
public interface TransferRepository extends JpaRepository<Payment, Long>{

	@Query("SELECT p from Payment p where p.sourceAccount=:sourceAcc")
	List<Payment> getTransferDetails(@Param("sourceAcc") Long sourceAcc);

}
