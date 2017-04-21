package com.dbs.cst.ircp.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class Input {

	private UUID fileId;
	private Date readTime;
	private Date completeTime;
	private String orgName;
	private Date transDate;
	private String headerValid;
	private int noOfAppmt;
	private BigDecimal appmtAmount;
	private BigDecimal nricHash;
	private BigDecimal amountHash;
	private int noOfRelease;
	private BigDecimal releaseAmount;
	private String trailerValid;
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
	
	
	public Input(){
		
	}
	public Input(UUID fileId, Date readTime, Date completeTime, String orgName, Date transDate, String headerValid,
			int noOfAppmt, BigDecimal appmtAmount, BigDecimal nricHash, BigDecimal amountHash, int noOfRelease,
			BigDecimal releaseAmount, String trailerValid, String nric, String nricReformat, String caseId, int taxType,
			String customerName, BigDecimal amountDue, Date appmtDate, Date releaseDate, Date fileDate, String isValid,
			int errorCode) {
		super();
		this.fileId = fileId;
		this.readTime = readTime;
		this.completeTime = completeTime;
		this.orgName = orgName;
		this.transDate = transDate;
		this.headerValid = headerValid;
		this.noOfAppmt = noOfAppmt;
		this.appmtAmount = appmtAmount;
		this.nricHash = nricHash;
		this.amountHash = amountHash;
		this.noOfRelease = noOfRelease;
		this.releaseAmount = releaseAmount;
		this.trailerValid = trailerValid;
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
	public UUID getFileId() {
		return fileId;
	}
	public void setFileId(UUID fileId) {
		this.fileId = fileId;
	}
	public Date getReadTime() {
		return readTime;
	}
	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}
	public Date getCompleteTime() {
		return completeTime;
	}
	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public String getHeaderValid() {
		return headerValid;
	}
	public void setHeaderValid(String headerValid) {
		this.headerValid = headerValid;
	}
	public int getNoOfAppmt() {
		return noOfAppmt;
	}
	public void setNoOfAppmt(int noOfAppmt) {
		this.noOfAppmt = noOfAppmt;
	}
	public BigDecimal getAppmtAmount() {
		return appmtAmount;
	}
	public void setAppmtAmount(BigDecimal appmtAmount) {
		this.appmtAmount = appmtAmount;
	}
	public BigDecimal getNricHash() {
		return nricHash;
	}
	public void setNricHash(BigDecimal nricHash) {
		this.nricHash = nricHash;
	}
	public BigDecimal getAmountHash() {
		return amountHash;
	}
	public void setAmountHash(BigDecimal amountHash) {
		this.amountHash = amountHash;
	}
	public int getNoOfRelease() {
		return noOfRelease;
	}
	public void setNoOfRelease(int noOfRelease) {
		this.noOfRelease = noOfRelease;
	}
	public BigDecimal getReleaseAmount() {
		return releaseAmount;
	}
	public void setReleaseAmount(BigDecimal releaseAmount) {
		this.releaseAmount = releaseAmount;
	}
	public String getTrailerValid() {
		return trailerValid;
	}
	public void setTrailerValid(String trailerValid) {
		this.trailerValid = trailerValid;
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
		return "Input [fileId=" + fileId + ", readTime=" + readTime + ", completeTime=" + completeTime + ", orgName="
				+ orgName + ", transDate=" + transDate + ", headerValid=" + headerValid + ", noOfAppmt=" + noOfAppmt
				+ ", appmtAmount=" + appmtAmount + ", nricHash=" + nricHash + ", amountHash=" + amountHash
				+ ", noOfRelease=" + noOfRelease + ", releaseAmount=" + releaseAmount + ", trailerValid=" + trailerValid
				+ ", nric=" + nric + ", nricReformat=" + nricReformat + ", caseId=" + caseId + ", taxType=" + taxType
				+ ", customerName=" + customerName + ", amountDue=" + amountDue + ", appmtDate=" + appmtDate
				+ ", releaseDate=" + releaseDate + ", fileDate=" + fileDate + ", isValid=" + isValid + ", errorCode="
				+ errorCode + "]";
	}
	
	
	
	
	
	
}
