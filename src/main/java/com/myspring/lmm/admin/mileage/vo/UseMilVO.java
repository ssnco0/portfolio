package com.myspring.lmm.admin.mileage.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("useMilVO")
public class UseMilVO {
	private String cusid;
	private String stoname;
	private int usemil;
	private Date usedate;
	private String cusname;

	public UseMilVO() {
	
	}

	public UseMilVO(String cusid, String stoname, int usemil, Date usedate, String cusname) {
		super();
		this.cusid = cusid;
		this.stoname = stoname;
		this.usemil = usemil;
		this.usedate = usedate;
		this.cusname = cusname;
	}

	public String getCusid() {
		return cusid;
	}

	public void setCusid(String cusid) {
		this.cusid = cusid;
	}

	public String getStoname() {
		return stoname;
	}

	public void setStoname(String stoname) {
		this.stoname = stoname;
	}

	public int getUsemil() {
		return usemil;
	}

	public void setUsemil(int usemil) {
		this.usemil = usemil;
	}

	public Date getUsedate() {
		return usedate;
	}

	public void setUsedate(Date usedate) {
		this.usedate = usedate;
	}

	public String getCusname() {
		return cusname;
	}

	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	
	
	
}
