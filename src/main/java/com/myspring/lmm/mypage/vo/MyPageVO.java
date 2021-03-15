package com.myspring.lmm.mypage.vo;

import org.springframework.stereotype.Component;

@Component("mypageVO")
public class MyPageVO {
	private String cusId;
	private String beginDate;
	private String endDate;
	
	public MyPageVO() {
	
	}

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	

	
	

}
