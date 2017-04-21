package com.dbs.cst.ircp.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;


public class IRASHeaderInput {
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
	

	public IRASHeaderInput() {
	}


	public IRASHeaderInput(UUID fileId, Date readTime, Date completeTime, String orgName, Date transDate,
			String headerValid, int noOfAppmt, BigDecimal appmtAmount, BigDecimal nricHash, BigDecimal amountHash,
			int noOfRelease, BigDecimal relAmount, String trailerValid) {
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
		this.releaseAmount = relAmount;
		this.trailerValid = trailerValid;
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


	public BigDecimal getRelAmount() {
		return releaseAmount;
	}


	public void setRelAmount(BigDecimal relAmount) {
		this.releaseAmount = relAmount;
	}


	public String getTrailerValid() {
		return trailerValid;
	}


	public void setTrailerValid(String trailerValid) {
		this.trailerValid = trailerValid;
	}


	@Override
	public String toString() {
		return "IRASHeaderInput [fileId=" + fileId + ", readTime=" + readTime + ", completeTime=" + completeTime
				+ ", orgName=" + orgName + ", transDate=" + transDate + ", headerValid=" + headerValid + ", noOfAppmt="
				+ noOfAppmt + ", appmtAmount=" + appmtAmount + ", nricHash=" + nricHash + ", amountHash=" + amountHash
				+ ", noOfRelease=" + noOfRelease + ", relAmount=" + releaseAmount + ", trailerValid=" + trailerValid + "]";
	}


}








