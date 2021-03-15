package com.myspring.lmm.intro.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("introVO")
public class IntroVO {

	private int siNo;
	private String siTitle;
	private String siContents;
	private Date siCreateDate;
	private int siViews;
	private String stoId;
	private String sBImageFileName;
	
	public IntroVO() {
		
	}
	public IntroVO(int siNo, String siTitle, String siContents, Date siCreateDate, int siViews, String stoId,
			String sBImageFileName) {
		
		this.siNo = siNo;
		this.siTitle = siTitle;
		this.siContents = siContents;
		this.siCreateDate = siCreateDate;
		this.siViews = siViews;
		this.stoId = stoId;
		this.sBImageFileName = sBImageFileName;
	}
	public int getSiNo() {
		return siNo;
	}
	public void setSiNo(int siNo) {
		this.siNo = siNo;
	}
	public String getSiTitle() {
		return siTitle;
	}
	public void setSiTitle(String siTitle) {
		this.siTitle = siTitle;
	}
	public String getSiContents() {
		return siContents;
	}
	public void setSiContents(String siContents) {
		this.siContents = siContents;
	}
	public Date getSiCreateDate() {
		return siCreateDate;
	}
	public void setSiCreateDate(Date siCreateDate) {
		this.siCreateDate = siCreateDate;
	}
	public int getSiViews() {
		return siViews;
	}
	public void setSiViews(int siViews) {
		this.siViews = siViews;
	}
	public String getStoId() {
		return stoId;
	}
	public void setStoId(String stoId) {
		this.stoId = stoId;
	}
	public String getsBImageFileName() {
		return sBImageFileName;
	}
	public void setsBImageFileName(String sBImageFileName) {
		try {
			if(sBImageFileName!= null && sBImageFileName.length()!=0) {
				this.sBImageFileName = URLEncoder.encode(sBImageFileName,"UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	
}
