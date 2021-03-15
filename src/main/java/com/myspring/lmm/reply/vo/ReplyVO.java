package com.myspring.lmm.reply.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("replyVO")
public class ReplyVO {

	private int reNo;
	private String reWriter;
	private String reContents;
	private Date reDate;
	private int qnaNo;
	public ReplyVO() {
		super();
	}
	public ReplyVO(int reNo, String reWriter, String reContents, Date reDate, int qnaNo) {
		super();
		this.reNo = reNo;
		this.reWriter = reWriter;
		this.reContents = reContents;
		this.reDate = reDate;
		this.qnaNo = qnaNo;
	}
	public int getReNo() {
		return reNo;
	}
	public void setReNo(int reNo) {
		this.reNo = reNo;
	}
	public String getReWriter() {
		return reWriter;
	}
	public void setReWriter(String reWriter) {
		this.reWriter = reWriter;
	}
	public String getReContents() {
		return reContents;
	}
	public void setReContents(String reContents) {
		this.reContents = reContents;
	}
	public Date getReDate() {
		return reDate;
	}
	public void setReDate(Date reDate) {
		this.reDate = reDate;
	}
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	
	
}
