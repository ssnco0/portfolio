package com.myspring.lmm.ntc.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("ntcVO")
public class NtcVO {

	private int ntcNo;
	private String ntcTitle;
	private String ntcContents;
	private String ntcitWriter;
	private Date ntcDate;
	private int ntcViews;
	
	public NtcVO() {
		
	}
	public NtcVO(int ntcNo, String ntcTitle, String ntcContents, String ntcitWriter, Date ntcDate, int ntcViews) {
		
		this.ntcNo = ntcNo;
		this.ntcTitle = ntcTitle;
		this.ntcContents = ntcContents;
		this.ntcitWriter = ntcitWriter;
		this.ntcDate = ntcDate;
		this.ntcViews = ntcViews;
	}
	public int getNtcNo() {
		return ntcNo;
	}
	public void setNtcNo(int ntcNo) {
		this.ntcNo = ntcNo;
	}
	public String getNtcTitle() {
		return ntcTitle;
	}
	public void setNtcTitle(String ntcTitle) {
		this.ntcTitle = ntcTitle;
	}
	public String getNtcContents() {
		return ntcContents;
	}
	public void setNtcContents(String ntcContents) {
		this.ntcContents = ntcContents;
	}
	public String getNtcitWriter() {
		return ntcitWriter;
	}
	public void setNtcitWriter(String ntcitWriter) {
		this.ntcitWriter = ntcitWriter;
	}
	public Date getNtcDate() {
		return ntcDate;
	}
	public void setNtcDate(Date ntcDate) {
		this.ntcDate = ntcDate;
	}
	public int getNtcViews() {
		return ntcViews;
	}
	public void setNtcViews(int ntcViews) {
		this.ntcViews = ntcViews;
	}
	
	
	
	
	
}
