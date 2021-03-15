package com.myspring.lmm.message.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("stoMessageVO")
public class StoMessageVO {
	private int smNo;
	private String smTitle;
	private String smContents;
	private Date smDate;
	private String stoId;
	
	public StoMessageVO() {
	
	}

	public StoMessageVO(int smNo, String smTitle, String smContents, Date smDate, String stoId) {
	    super();
	    this.smNo = smNo;
	    this.smTitle = smTitle;
	    this.smContents = smContents;
	    this.smDate = smDate;
	    this.stoId = stoId;
	}

	public int getSmNo() {
	    return smNo;
	}

	public void setSmNo(int smNo) {
	    this.smNo = smNo;
	}

	public String getSmTitle() {
	    return smTitle;
	}

	public void setSmTitle(String smTitle) {
	    this.smTitle = smTitle;
	}

	public String getSmContents() {
	    return smContents;
	}

	public void setSmContents(String smContents) {
	    this.smContents = smContents;
	}

	public Date getSmDate() {
	    return smDate;
	}

	public void setSmDate(Date smDate) {
	    this.smDate = smDate;
	}

	public String getStoId() {
	    return stoId;
	}

	public void setStoId(String stoId) {
	    this.stoId = stoId;
	}
	
	
	
	

}
