package com.myspring.lmm.message.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("messageVO")
public class MessageVO {
	private int umNum;
	private String umTitle;
	private String umContents;
	private Date umDate;
	private String cusId;
	
	
	
	public MessageVO() {
		super();
	}
	
	public MessageVO(int umNum, String umTitle, String umContents, Date umDate, String cusId) {
		super();
		this.umNum = umNum;
		this.umTitle = umTitle;
		this.umContents = umContents;
		this.umDate = umDate;
		this.cusId = cusId;
	}
	
	public int getUmNum() {
		return umNum;
	}
	
	public void setUmNum(int umNum) {
		this.umNum = umNum;
	}
	
	public String getUmTitle() {
		return umTitle;
	}
	
	public void setUmTitle(String umTitle) {
		this.umTitle = umTitle;
	}
	
	public String getUmContents() {
		return umContents;
	}
	
	public void setUmContents(String umContents) {
		this.umContents = umContents;
	}
	
	public Date getUmDate() {
		return umDate;
	}
	
	public void setUmDate(Date umDate) {
		this.umDate = umDate;
	}
	
	public String getCusId() {
		return cusId;
	}
	
	public void setCusId(String cusId) {
		this.cusId = cusId;
	}
	
}
