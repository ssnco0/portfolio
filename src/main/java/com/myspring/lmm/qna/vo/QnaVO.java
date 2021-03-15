package com.myspring.lmm.qna.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("qnaVO")
public class QnaVO {

	private int qnaNo;
	private String qnaTitle;
	private String qnaContents;
	private String qnaWriter;
	private Date qnaCreateDate;
	
	public QnaVO() {
	
	}
	public QnaVO(int qnaNo, String qnaTitle, String qnaContents, String qnaWriter, Date qnaCreateDate) {
		
		this.qnaNo = qnaNo;
		this.qnaTitle = qnaTitle;
		this.qnaContents = qnaContents;
		this.qnaWriter = qnaWriter;
		this.qnaCreateDate = qnaCreateDate;
	
	}
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContents() {
		return qnaContents;
	}
	public void setQnaContents(String qnaContents) {
		this.qnaContents = qnaContents;
	}
	public String getQnaWriter() {
		return qnaWriter;
	}
	public void setQnaWriter(String qnaWriter) {
		this.qnaWriter = qnaWriter;
	}
	public Date getQnaCreateDate() {
		return qnaCreateDate;
	}
	public void setQnaCreateDate(Date qnaCreateDate) {
		this.qnaCreateDate = qnaCreateDate;
	}
	
	 
	
	
}
