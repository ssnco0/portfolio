package com.myspring.lmm.payment.vo;

import org.springframework.stereotype.Component;

@Component("paySaveVO")
public class PaySaveVO {
	private int payNum;
	private String stoId;
	private int payAco;
	private String cusId;
	private int payUseMil;
	private int cupId;
	private int cupQrNo;
	private int cupDisCount;
	private int payReal;
	private int milStack;
	
	public PaySaveVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaySaveVO(int payNum, String stoId, int payAco, String cusId, int payUseMil, int cupId, int cupQrNo, int cupDisCount, int payReal,
			int milStack) {
		super();
		this.payNum = payNum;
		this.stoId = stoId;
		this.payAco = payAco;
		this.cusId = cusId;
		this.payUseMil = payUseMil;
		this.cupId = cupId;
		this.cupQrNo = cupQrNo;
		this.cupDisCount = cupDisCount;
		this.payReal = payReal;
		this.milStack = milStack;
	}

	public int getPayNum() {
		return payNum;
	}

	public void setPayNum(int payNum) {
		this.payNum = payNum;
	}

	public int getCupId() {
		return cupId;
	}

	public void setCupId(int cupId) {
		this.cupId = cupId;
	}

	public String getStoId() {
		return stoId;
	}

	public void setStoId(String stoId) {
		this.stoId = stoId;
	}

	public int getPayAco() {
		return payAco;
	}

	public void setPayAco(int payAco) {
		this.payAco = payAco;
	}

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public int getPayUseMil() {
		return payUseMil;
	}

	public void setPayUseMil(int payUseMil) {
		this.payUseMil = payUseMil;
	}

	public int getCupQrNo() {
		return cupQrNo;
	}

	public void setCupQrNo(int cupQrNo) {
		this.cupQrNo = cupQrNo;
	}

	public int getCupDisCount() {
		return cupDisCount;
	}

	public void setCupDisCount(int cupDisCount) {
		this.cupDisCount = cupDisCount;
	}

	public int getPayReal() {
		return payReal;
	}

	public void setPayReal(int payReal) {
		this.payReal = payReal;
	}

	public int getMilStack() {
		return milStack;
	}

	public void setMilStack(int milStack) {
		this.milStack = milStack;
	}
	
	
}
