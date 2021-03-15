package com.myspring.lmm.mileage.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("mileageVO")
public class MileageVO {
	private int milNo;
	private int milStack;
	private int payNum;
	private String cusId;
	private Date milDate;
	
	public MileageVO() {
		
	}

	public MileageVO(int milNo, int milStack, int payNum, String cusId, Date milDate) {
		
		this.milNo = milNo;
		this.milStack = milStack;
		this.payNum = payNum;
		this.cusId = cusId;
		this.milDate = milDate;
	}

	public int getMilNo() {
		return milNo;
	}

	public void setMilNo(int milNo) {
		this.milNo = milNo;
	}

	public int getMilStack() {
		return milStack;
	}

	public void setMilStack(int milStack) {
		this.milStack = milStack;
	}

	public int getPayNum() {
		return payNum;
	}

	public void setPayNum(int payNum) {
		this.payNum = payNum;
	}

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public Date getMilDate() {
		return milDate;
	}

	public void setMilDate(Date milDate) {
		this.milDate = milDate;
	}	

	
	
}
