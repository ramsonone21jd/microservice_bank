package com.bank.transfer.util;

import com.bank.transfer.dto.PaymentDTO;
import com.bank.transfer.entity.Payment;

public class TransferUtil {

	
	
   public static final String GET_ACCOUNT = "http://localhost:8081/ms_account/account/getAccount";
   public static final String UPDATE_ACCOUNT = "http://localhost:8081/ms_account/account/updateAccount";
   public static final String UPDATE_BALANCE = "http://localhost:8081/ms_account/account/updateBalance/{accNo}/{balance}";
   
   
   public static final String INSUFFICIENT_FUND = "Insufficient fund in the account";
   
   
   
   public static PaymentDTO getPaymentDTO(Payment pmt, PaymentDTO dto) {
	   if(pmt !=null) {
		    dto.setPaymentId(pmt.getPaymentId());
			dto.setPaymentName(pmt.getPaymentName());
			dto.setAmount(pmt.getAmount());
			dto.setSourceAccount(pmt.getSourceAccount());
			dto.setToAccountNo(pmt.getToAccountNo());
	   }	   
		return dto;
    }

public static PaymentDTO getPaymentDTO(Payment pmt) {
	PaymentDTO dto= new PaymentDTO();
	dto.setPaymentId(pmt.getPaymentId());
	dto.setPaymentName(pmt.getPaymentName());
	dto.setAmount(pmt.getAmount());
	dto.setSourceAccount(pmt.getSourceAccount());
	dto.setToAccountNo(pmt.getToAccountNo());
	return dto;
}
}
