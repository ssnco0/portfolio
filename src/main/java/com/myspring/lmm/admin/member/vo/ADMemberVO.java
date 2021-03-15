package com.myspring.lmm.admin.member.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("ADmemberVO")
public class ADMemberVO {
	private String cusid;
	private String cusphone;
	private String cuspassword;
	private String cusemail;
	private String cusname;
	private int cusbirth;
	private String cusadress;
	private Date Cussignupdate;
	private String cusadv;
	private int cusqrno;
	private int custotmil;

	public ADMemberVO(String cusid, String cusphone, String cuspassword, String cusemail, String cusname, int cusbirth,
			String cusadress, Date cussignupdate, String cusadv, int cusqrno, int custotmil) {
		super();
		this.cusid = cusid;
		this.cusphone = cusphone;
		this.cuspassword = cuspassword;
		this.cusemail = cusemail;
		this.cusname = cusname;
		this.cusbirth = cusbirth;
		this.cusadress = cusadress;
		Cussignupdate = cussignupdate;
		this.cusadv = cusadv;
		this.cusqrno = cusqrno;
		this.custotmil = custotmil;
	}

	public ADMemberVO() {
		
	}

	public String getCusid() {
		return cusid;
	}

	public void setCusid(String cusid) {
		this.cusid = cusid;
	}

	public String getCusphone() {
		return cusphone;
	}

	public void setCusphone(String cusphone) {
		this.cusphone = cusphone;
	}

	public String getCuspassword() {
		return cuspassword;
	}

	public void setCuspassword(String cuspassword) {
		this.cuspassword = cuspassword;
	}

	public String getCusemail() {
		return cusemail;
	}

	public void setCusemail(String cusemail) {
		this.cusemail = cusemail;
	}

	public String getCusname() {
		return cusname;
	}

	public void setCusname(String cusname) {
		this.cusname = cusname;
	}

	public int getCusbirth() {
		return cusbirth;
	}

	public void setCusbirth(int cusbirth) {
		this.cusbirth = cusbirth;
	}

	public String getCusadress() {
		return cusadress;
	}

	public void setCusadress(String cusadress) {
		this.cusadress = cusadress;
	}

	public Date getCussignupdate() {
		return Cussignupdate;
	}

	public void setCussignupdate(Date cussignupdate) {
		Cussignupdate = cussignupdate;
	}

	public String getCusadv() {
		return cusadv;
	}

	public void setCusadv(String cusadv) {
		this.cusadv = cusadv;
	}

	public int getCusqrno() {
		return cusqrno;
	}

	public void setCusqrno(int cusqrno) {
		this.cusqrno = cusqrno;
	}

	public int getCustotmil() {
		return custotmil;
	}

	public void setCustotmil(int custotmil) {
		this.custotmil = custotmil;
	}

	

	

}
