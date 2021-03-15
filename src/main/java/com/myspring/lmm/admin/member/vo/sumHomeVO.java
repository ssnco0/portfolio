package com.myspring.lmm.admin.member.vo;

import org.springframework.stereotype.Component;

@Component("sumhomeVO")
public class sumHomeVO {
	private String cusid;
	private int summilstack;
	private int sumusemil;
		
	public sumHomeVO() {
		super();
	}
	
	public sumHomeVO(String cusid, int summilstack, int sumusemil) {
		super();
		this.cusid = cusid;
		this.summilstack = summilstack;
		this.sumusemil = sumusemil;
	}

	public String getCusid() {
		return cusid;
	}
	public void setCusid(String cusid) {
		this.cusid = cusid;
	}
	public int getSummilstack() {
		return summilstack;
	}
	public void setSummilstack(int summilstack) {
		this.summilstack = summilstack;
	}
	public int getSumusemil() {
		return sumusemil;
	}
	public void setSumusemil(int sumusemil) {
		this.sumusemil = sumusemil;
	}
	

	
}
