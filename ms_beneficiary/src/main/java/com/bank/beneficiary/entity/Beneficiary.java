package com.bank.beneficiary.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="BENEFICIARY")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Beneficiary implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long benId;
	
	@Column(name="ben_Name")
	private String benName;
	
	@Column(name="acc_No")
	private Long accNo;
	
	@Column(name="ben_acc_no")
	private Long benAccNo;

	public Long getBenId() {
		return benId;
	}

	public void setBenId(Long benId) {
		this.benId = benId;
	}

	public String getBenName() {
		return benName;
	}

	public void setBenName(String benName) {
		this.benName = benName;
	}
	//@JsonIgnore
	public Long getAccNo() {
		return accNo;
	}

	/* @JsonIgnore */
	public void setAccNo(Long accNo) {
		this.accNo = accNo;
	}

	public Long getBenAccNo() {
		return benAccNo;
	}

	public void setBenAccNo(Long benAccNo) {
		this.benAccNo = benAccNo;
	}
	
	
	

}
