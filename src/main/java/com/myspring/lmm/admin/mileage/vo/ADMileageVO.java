package com.myspring.lmm.admin.mileage.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("ADmileageVO")
public class ADMileageVO {
	private int milno;
	private int milstack;
	private int paynum;
	private String cusid;
	private Date mildate;
	
	
	public ADMileageVO() {
		
	}
	public ADMileageVO(int milno, int milstack,int paynum, String cusid, Date mildate) {
		super();
		this.milno = milno;
		this.milstack = milstack;
		this.cusid = cusid;
		this.mildate = mildate;
	}
	public int getMilno() {
		return milno;
	}
	public int getPaynum() {
		return paynum;
	}
	public void setPaynum(int paynum) {
		this.paynum = paynum;
	}
	public void setMilno(int milno) {
		this.milno = milno;
	}
	public int getMilstack() {
		return milstack;
	}
	public void setMilstack(int milstack) {
		this.milstack = milstack;
	}
	public String getCusid() {
		return cusid;
	}
	public void setCusid(String cusid) {
		this.cusid = cusid;
	}
	public Date getMildate() {
		return mildate;
	}
	public void setMildate(Date mildate) {
		this.mildate = mildate;
	}
	
	
}
