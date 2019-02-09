package com.bank.transfer.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class PaymentDTO {

private Long paymentId;


	private String paymentName;	
	private Long toAccountNo;
	private BigDecimal amount;
	private Date paymentDate;
	private Long sourceAccount;
	private String errorMsg;	
	
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentName() {
		return paymentName;
	}
	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}
	public Long getToAccountNo() {
		return toAccountNo;
	}
	public void setToAccountNo(Long toAccountNo) {
		this.toAccountNo = toAccountNo;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Long getSourceAccount() {
		return sourceAccount;
	}
	public void setSourceAccount(Long sourceAccount) {
		this.sourceAccount = sourceAccount;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
