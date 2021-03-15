package com.myspring.lmm.intro.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("storeBoardVO")
public class StoreBoardVO {

	private int sBNo;
	private String sBImageFileName;
	private Date sBDate;
	private int siNo;
		
	public int getsBNo() {
		return sBNo;
	}
	public void setsBNo(int sBNo) {
		this.sBNo = sBNo;
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
	public Date getsBDate() {
		return sBDate;
	}
	public void setsBDate(Date sBDate) {
		this.sBDate = sBDate;
	}
	public int getSiNo() {
		return siNo;
	}
	public void setSiNo(int siNo) {
		this.siNo = siNo;
	}
	
	
	
	
}
