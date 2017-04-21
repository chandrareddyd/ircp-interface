package com.dbs.cst.ircp.model;

import java.math.BigDecimal;
import java.util.Date;


public class IRASDetailsInput {
	private String fileId;
	private String nric;
	private String nricReformat;
	private String caseId;
	private int taxType;
	private String customerName;
	private BigDecimal amountDue;
	private Date appmtDate;
	private Date releaseDate;
	private Date fileDate;
	private String isValid;
	private int errorCode;
	
	
	public IRASDetailsInput() {
	}


	public IRASDetailsInput(String fileId, String nric, String nricReformat, String caseId, int taxType,
			String customerName, BigDecimal amountDue, Date appmtDate, Date releaseDate, Date fileDate, String isValid,
			int errorCode) {
		super();
		this.fileId = fileId;
		this.nric = nric;
		this.nricReformat = nricReformat;
		this.caseId = caseId;
		this.taxType = taxType;
		this.customerName = customerName;
		this.amountDue = amountDue;
		this.appmtDate = appmtDate;
		this.releaseDate = releaseDate;
		this.fileDate = fileDate;
		this.isValid = isValid;
		this.errorCode = errorCode;
	}


	public String getFileId() {
		return fileId;
	}


	public void setFileId(String fileId) {
		this.fileId = fileId;
	}


	public String getNric() {
		return nric;
	}


	public void setNric(String nric) {
		this.nric = nric;
	}


	public String getNricReformat() {
		return nricReformat;
	}


	public void setNricReformat(String nricReformat) {
		this.nricReformat = nricReformat;
	}


	public String getCaseId() {
		return caseId;
	}


	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}


	public int getTaxType() {
		return taxType;
	}


	public void setTaxType(int taxType) {
		this.taxType = taxType;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public BigDecimal getAmountDue() {
		return amountDue;
	}


	public void setAmountDue(BigDecimal amountDue) {
		this.amountDue = amountDue;
	}


	public Date getAppmtDate() {
		return appmtDate;
	}


	public void setAppmtDate(Date appmtDate) {
		this.appmtDate = appmtDate;
	}


	public Date getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}


	public Date getFileDate() {
		return fileDate;
	}


	public void setFileDate(Date fileDate) {
		this.fileDate = fileDate;
	}


	public String getIsValid() {
		return isValid;
	}


	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}


	public int getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}


	@Override
	public String toString() {
		return "IRASDetailsInput [fileId=" + fileId + ", nric=" + nric + ", nricReformat=" + nricReformat + ", caseId="
				+ caseId + ", taxType=" + taxType + ", customerName=" + customerName + ", amountDue=" + amountDue
				+ ", appmtDate=" + appmtDate + ", releaseDate=" + releaseDate + ", fileDate=" + fileDate + ", isValid="
				+ isValid + ", errorCode=" + errorCode + "]";
	}
	

	
}





























