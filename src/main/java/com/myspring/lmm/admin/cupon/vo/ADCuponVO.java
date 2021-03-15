package com.myspring.lmm.admin.cupon.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("ADcuponVO")
public class ADCuponVO {
	private int cupid;
	private int cupqrno;
	private Date cupdate;
	private int cupdiscount;
	private Date cupusedate;
	private String cupkind;
	private String cupadvcontents;
	private String cusid;
	private String stoid;
	
	public ADCuponVO() {

	}

	public ADCuponVO(int cupid, int cupqrno, Date cupdate, int cupdiscount, Date cupusedate, String cupkind,
			String cupadvcontents, String cusid, String stoid) {
		this.cupid = cupid;
		this.cupqrno = cupqrno;
		this.cupdate = cupdate;
		this.cupdiscount = cupdiscount;
		this.cupusedate = cupusedate;
		this.cupkind = cupkind;
		this.cupadvcontents = cupadvcontents;
		this.cusid = cusid;
		this.stoid = stoid;
	}

	public int getCupid() {
		return cupid;
	}

	public void setCupid(int cupid) {
		this.cupid = cupid;
	}

	public int getCupqrno() {
		return cupqrno;
	}

	public void setCupqrno(int cupqrno) {
		this.cupqrno = cupqrno;
	}

	public Date getCupdate() {
		return cupdate;
	}

	public void setCupdate(Date cupdate) {
		this.cupdate = cupdate;
	}

	public int getCupdiscount() {
		return cupdiscount;
	}

	public void setCupdiscount(int cupdiscount) {
		this.cupdiscount = cupdiscount;
	}

	public Date getCupusedate() {
		return cupusedate;
	}

	public void setCupusedate(Date cupusedate) {
		this.cupusedate = cupusedate;
	}

	public String getCupkind() {
		return cupkind;
	}

	public void setCupkind(String cupkind) {
		this.cupkind = cupkind;
	}

	public String getCupadvcontents() {
		return cupadvcontents;
	}

	public void setCupadvcontents(String cupadvcontents) {
		this.cupadvcontents = cupadvcontents;
	}

	public String getCusid() {
		return cusid;
	}

	public void setCusid(String cusid) {
		this.cusid = cusid;
	}

	public String getStoid() {
		return stoid;
	}

	public void setStoid(String stoid) {
		this.stoid = stoid;
	}
	
	
}
