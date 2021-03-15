package com.myspring.lmm.member.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("memberVO")
public class MemberVO {
	private String cusId;
	private String cusPhone;
	private String cusPassword;
	private String cusEmail;
	private String cusName;
	private int cusBirth;
	private String cusAdress;
	private Date cusSignupDate;
	private String cusAdv;
	private int cusQrNo;
	private int cusTotMil;
	
	public MemberVO() {
		
	}

	public MemberVO(String cusId, String cusPhone, String cusPassword, String cusEmail, String cusName, int cusBirth,
			String cusAdress, Date cusSignupDate, String cusAdv, int cusQrNo, int cusTotMil) {
		
		this.cusId = cusId;
		this.cusPhone = cusPhone;
		this.cusPassword = cusPassword;
		this.cusEmail = cusEmail;
		this.cusName = cusName;
		this.cusBirth = cusBirth;
		this.cusAdress = cusAdress;
		this.cusSignupDate = cusSignupDate;
		this.cusAdv = cusAdv;
		this.cusQrNo = cusQrNo;
		this.cusTotMil = cusTotMil;
	}
	
	public String getCusId() {
		return cusId;
	}
	public void setCusId(String cusId) {
		this.cusId = cusId;
	}
	public String getCusPhone() {
		return cusPhone;
	}
	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}
	public String getCusPassword() {
		return cusPassword;
	}
	public void setCusPassword(String cusPassword) {
		this.cusPassword = cusPassword;
	}
	public String getCusEmail() {
		return cusEmail;
	}
	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public int getCusBirth() {
		return cusBirth;
	}
	public void setCusBirth(int cusBirth) {
		this.cusBirth = cusBirth;
	}
	public String getCusAdress() {
		return cusAdress;
	}
	public void setCusAdress(String cusAdress) {
		this.cusAdress = cusAdress;
	}
	public Date getCusSignupDate() {
		return cusSignupDate;
	}
	public void setCusSignupDate(Date cusSignupDate) {
		this.cusSignupDate = cusSignupDate;
	}
	public String getCusAdv() {
		return cusAdv;
	}
	public void setCusAdv(String cusAdv) {
		this.cusAdv = cusAdv;
	}
	public int getCusQrNo() {
		return cusQrNo;
	}
	public void setCusQrNo(int cusQrNo) {
		this.cusQrNo = cusQrNo;
	}
	public int getCusTotMil() {
		return cusTotMil;
	}
	public void setCusTotMil(int cusTotMil) {
		this.cusTotMil = cusTotMil;
	}
	

	
	
	
}
