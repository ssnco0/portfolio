package com.myspring.lmm.admin.member.vo;

import org.springframework.stereotype.Component;

@Component("managerVO")
public class ManagerVO {
	private String manId;
	private String manPassword;
	private String manName;
	private String manAuthority;
	private String manPhone;
	private String manEmail;
	
	public ManagerVO() {

	}
	public ManagerVO(String manId, String manPassword, String manName, String manAuthority, String manPhone, String manEmail) {
		super();
		this.manId = manId; 
		this.manPassword = manPassword;
		this.manName = manName;
		this.manAuthority = manAuthority;
		this.manPhone = manPhone;
		this.manEmail = manEmail;
	}
	public String getManId() {
		return manId;
	}
	public void setManId(String manId) {
		this.manId = manId;
	}
	public String getManPassword() {
		return manPassword;
	}
	public void setManPassword(String manPassword) {
		this.manPassword = manPassword;
	}
	public String getManName() {
		return manName;
	}
	public void setManName(String manName) {
		this.manName = manName;
	}
	public String getManAuthority() {
		return manAuthority;
	}
	public void setManAuthority(String manAuthority) {
		this.manAuthority = manAuthority;
	}
	public String getManPhone() {
		return manPhone;
	}
	public void setManPhone(String manPhone) {
		this.manPhone = manPhone;
	}
	public String getManEmail() {
		return manEmail;
	}
	public void setManEmail(String manEmail) {
		this.manEmail = manEmail;
	}
	
	
	
	
}
