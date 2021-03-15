package com.myspring.lmm.store.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("storeVO")
public class StoreVO {
	private String stoId; //���̵�
	private String stoPhone; // ��
	private String stoPassword;//���
	private String stoEmail;//�̸�
	private String stoName; //��������
	private String stoAdress;//�ּ�
	private int stoBuiNum;//����ڹ�ȣ
	private Date stoSignDate;//������
	private String stoLocNum;//������ȣ
	private String stoSignApp;//����
	
	public StoreVO() {
	  
	}
	
	public StoreVO(String stoId, String stoPhone, String stoPassword, String stoEmail, String stoName, String stoAdress, int stoBuiNum, Date stoSignDate, String stoLocNum, String stoSignApp) {
	   
	    this.stoId = stoId;
	    this.stoPhone = stoPhone;
	    this.stoPassword = stoPassword;
	    this.stoEmail = stoEmail;
	    this.stoName = stoName;
	    this.stoAdress = stoAdress;
	    this.stoBuiNum = stoBuiNum;
	    this.stoSignDate = stoSignDate;
	    this.stoLocNum = stoLocNum;
	    this.stoSignApp = stoSignApp;
	}
	
	public String getStoId() {
	    return stoId;
	}
	public void setStoId(String stoId) {
	    this.stoId = stoId;
	}
	public String getStoPhone() {
	    return stoPhone;
	}
	public void setStoPhone(String stoPhone) {
	    this.stoPhone = stoPhone;
	}
	public String getStoPassword() {
	    return stoPassword;
	}
	public void setStoPassword(String stoPassword) {
	    this.stoPassword = stoPassword;
	}
	public String getStoEmail() {
	    return stoEmail;
	}
	public void setStoEmail(String stoEmail) {
	    this.stoEmail = stoEmail;
	}
	public String getStoName() {
	    return stoName;
	}
	public void setStoName(String stoName) {
	    this.stoName = stoName;
	}
	public String getStoAdress() {
	    return stoAdress;
	}
	public void setStoAdress(String stoAdress) {
	    this.stoAdress = stoAdress;
	}
	public int getStoBuiNum() {
	    return stoBuiNum;
	}
	public void setStoBuiNum(int stoBuiNum) {
	    this.stoBuiNum = stoBuiNum;
	}
	public Date getStoSignDate() {
	    return stoSignDate;
	}
	public void setStoSignDate(Date stoSignDate) {
	    this.stoSignDate = stoSignDate;
	}
	public String getStoLocNum() {
	    return stoLocNum;
	}
	public void setStoLocNum(String stoLocNum) {
	    this.stoLocNum = stoLocNum;
	}
	public String getStoSignApp() {
	    return stoSignApp;
	}
	public void setStoSignApp(String stoSignApp) {
	    this.stoSignApp = stoSignApp;
	}
	
	
		
	
}