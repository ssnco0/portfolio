package com.myspring.lmm.cupon.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("cuponVO")
public class CuponVO {
	
	private int cupId;
	private int cupQrNo;
	private Date cupDate;
	private int cupDiscount;
	private Date cupUseDate;
	private String cupKind;
	private String cupAdvContents;
	private String cusId;
	private String stoId;
	
	public CuponVO() {
	
	}
	
	public CuponVO(int cupId, int cupQrNo, Date cupDate, int cupDiscount, Date cupUseDate, String cupKind,
			String cupAdvContents, String cusId, String stoId) {
		
		this.cupId = cupId;
		this.cupQrNo = cupQrNo;
		this.cupDate = cupDate;
		this.cupDiscount = cupDiscount;
		this.cupUseDate = cupUseDate;
		this.cupKind = cupKind;
		this.cupAdvContents = cupAdvContents;
		this.cusId = cusId;
		this.stoId = stoId;
	}
	public int getCupId() {
		return cupId;
	}
	public void setCupId(int cupId) {
		this.cupId = cupId;
	}
	public int getCupQrNo() {
		return cupQrNo;
	}
	public void setCupQrNo(int cupQrNo) {
		this.cupQrNo = cupQrNo;
	}
	public Date getCupDate() {
		return cupDate;
	}
	public void setCupDate(Date cupDate) {
		this.cupDate = cupDate;
	}
	public int getCupDiscount() {
		return cupDiscount;
	}
	public void setCupDiscount(int cupDiscount) {
		this.cupDiscount = cupDiscount;
	}
	public Date getCupUseDate() {
		return cupUseDate;
	}
	public void setCupUseDate(Date cupUseDate) {
		this.cupUseDate = cupUseDate;
	}
	public String getCupKind() {
		return cupKind;
	}
	public void setCupKind(String cupKind) {
		this.cupKind = cupKind;
	}
	public String getCupAdvContents() {
		return cupAdvContents;
	}
	public void setCupAdvContents(String cupAdvContents) {
		this.cupAdvContents = cupAdvContents;
	}
	public String getCusId() {
		return cusId;
	}
	public void setCusId(String cusId) {
		this.cusId = cusId;
	}
	public String getStoId() {
		return stoId;
	}
	public void setStoId(String stoId) {
		this.stoId = stoId;
	}
	
	

}
