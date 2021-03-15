package com.myspring.lmm.payment.vo;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

@Component("paymentVO")
public class PaymentVO {
	private int payNum;
	private int payAco;
	private int payReal;
	private Date payDate;
	private int payUseMil;
	private int milStack;
	private String payType;
	private String stoId;
	private String cusId;
	private int cupId;	
	
	
	public PaymentVO() {
		
	}

	public PaymentVO(int payNum, int payAco, int payReal, Date payDate, int payUseMil,int milStack, String payType, String stoId,
			String cusId, int cupId) {
		
		this.payNum = payNum;
		this.payAco = payAco;
		this.payReal = payReal;
		this.payDate = payDate;
		this.payUseMil = payUseMil;
		this.milStack = milStack;
		this.payType = payType;
		this.stoId = stoId;
		this.cusId = cusId;
		this.cupId = cupId;
	}

	public int getMilStack() {
		return milStack;
	}

	public void setMilStack(int milStack) {
		this.milStack = milStack;
	}

	public int getPayNum() {
		return payNum;
	}

	public void setPayNum(int payNum) {
		this.payNum = payNum;
	}

	public int getPayAco() {
		return payAco;
	}

	public void setPayAco(int payAco) {
		this.payAco = payAco;
	}

	public int getPayReal() {
		return payReal;
	}

	public void setPayReal(int payReal) {
		this.payReal = payReal;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
	
		
		this.payDate = payDate;
	}

	public int getPayUseMil() {
		return payUseMil;
	}

	public void setPayUseMil(int payUseMil) {
		this.payUseMil = payUseMil;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getStoId() {
		return stoId;
	}

	public void setStoId(String stoId) {
		this.stoId = stoId;
	}

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public int getCupId() {
		return cupId;
	}

	public void setCupId(int cupId) {
		this.cupId = cupId;
	}
	
	

	
}
