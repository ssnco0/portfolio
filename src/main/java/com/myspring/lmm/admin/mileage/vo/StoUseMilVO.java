package com.myspring.lmm.admin.mileage.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("stoUseMilVO")
public class StoUseMilVO {
	private String stoid;
	private String stoname;
	private String stoadress;
	private String stolocnum;
	private String cusid;
	private String cusname;
	private int payusemil;
	private Date paydate;
	
	public StoUseMilVO() {

	}
	
	public StoUseMilVO(String stoid, String stoname, String stoadress, String stolocnum, String cusid, String cusname,
			int payusemil, Date paydate) {
		super();
		this.stoid = stoid;
		this.stoname = stoname;
		this.stoadress = stoadress;
		this.stolocnum = stolocnum;
		this.cusid = cusid;
		this.cusname = cusname;
		this.payusemil = payusemil;
		this.paydate = paydate;
	}
	public String getStoid() {
		return stoid;
	}
	public void setStoid(String stoid) {
		this.stoid = stoid;
	}
	public String getStoname() {
		return stoname;
	}
	public void setStoname(String stoname) {
		this.stoname = stoname;
	}
	public String getStoadress() {
		return stoadress;
	}
	public void setStoadress(String stoadress) {
		this.stoadress = stoadress;
	}
	public String getStolocnum() {
		return stolocnum;
	}
	public void setStolocnum(String stolocnum) {
		this.stolocnum = stolocnum;
	}
	public String getCusid() {
		return cusid;
	}
	public void setCusid(String cusid) {
		this.cusid = cusid;
	}
	public String getCusname() {
		return cusname;
	}
	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	public int getPayusemil() {
		return payusemil;
	}
	public void setPayusemil(int payusemil) {
		this.payusemil = payusemil;
	}
	public Date getPaydate() {
		return paydate;
	}
	public void setPaydate(Date paydate) {
		this.paydate = paydate;
	}
	
}
