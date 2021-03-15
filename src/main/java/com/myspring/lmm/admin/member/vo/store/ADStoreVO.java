package com.myspring.lmm.admin.member.vo.store;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("ADstoreVO")
public class ADStoreVO {
	private String stoid ;
	private String stophone;
	private String stopassword;
	private String stoemail;
	private String stoname;
	private String stoadress;
	private int stobuinum;
	private Date stosigndate;
	private String stolocnum;
	private int stosignapp;
	public ADStoreVO(String stoid, String stophone, String stopassword, String stoemail, String stoname, String stoadress,
			int stobuinum, Date stosigndate, String stolocnum, int stosignapp) {
		super();
		this.stoid = stoid;
		this.stophone = stophone;
		this.stopassword = stopassword;
		this.stoemail = stoemail;
		this.stoname = stoname;
		this.stoadress = stoadress;
		this.stobuinum = stobuinum;
		this.stosigndate = stosigndate;
		this.stolocnum = stolocnum;
		this.stosignapp = stosignapp;
	}
	
	public ADStoreVO() {
		
	}

	public String getStoid() {
		return stoid;
	}

	public void setStoid(String stoid) {
		this.stoid = stoid;
	}

	public String getStophone() {
		return stophone;
	}

	public void setStophone(String stophone) {
		this.stophone = stophone;
	}

	public String getStopassword() {
		return stopassword;
	}

	public void setStopassword(String stopassword) {
		this.stopassword = stopassword;
	}

	public String getStoemail() {
		return stoemail;
	}

	public void setStoemail(String stoemail) {
		this.stoemail = stoemail;
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

	public int getStobuinum() {
		return stobuinum;
	}

	public void setStobuinum(int stobuinum) {
		this.stobuinum = stobuinum;
	}

	public Date getStosigndate() {
		return stosigndate;
	}

	public void setStosigndate(Date stosigndate) {
		this.stosigndate = stosigndate;
	}

	public String getStolocnum() {
		return stolocnum;
	}

	public void setStolocnum(String stolocnum) {
		this.stolocnum = stolocnum;
	}

	public int getStosignapp() {
		return stosignapp;
	}

	public void setStosignapp(int stosignapp) {
		this.stosignapp = stosignapp;
	}
	
	
}
