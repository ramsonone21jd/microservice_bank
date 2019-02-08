package com.bank.transfer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="PAYMENT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Payment implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long paymentId;
	
	@Column(name="payment_Name")
	private String paymentName;	
	
	@Column(name="from_Account_Num")
	private Long fromAccountNum;
	
	@Column(name="to_Account_No")
	private Long toAccountNo;
	
	@Column(name="amount")
	private BigDecimal amount;
	
	@Column(name="payment_Date", columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private Date paymentDate;
	
	@Column(name="source_Account")
	private Long sourceAccount;

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

	public Long getFromAccountNum() {
		return fromAccountNum;
	}

	public void setFromAccountNum(Long fromAccountNum) {
		this.fromAccountNum = fromAccountNum;
	}

	public Long getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(Long sourceAccount) {
		this.sourceAccount = sourceAccount;
	}
	
	

}
