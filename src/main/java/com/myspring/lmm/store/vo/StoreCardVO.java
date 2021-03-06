package com.myspring.lmm.store.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;

public class StoreCardVO {
    private int	scNo; //腰硲
    private String scImageFileName; //井稽
    private Date scDate;//去系析
    private String stoId;//亜戸繊焼戚巨びびびびびびびびびびびび
    


    public int getScNo() {
        return scNo;
    }

    public void setScNo(int scNo) {
        this.scNo = scNo;
    }

    public String getScImageFileName() {
        return scImageFileName;
    }

    public void setScImageFileName(String scImageFileName) {
	try {
		if(scImageFileName!= null && scImageFileName.length()!=0) {
			this.scImageFileName = URLEncoder.encode(scImageFileName,"UTF-8");
		}
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
    }
    public Date getScDate() {
        return scDate;
    }

    public void setScDate(Date scDate) {
        this.scDate = scDate;
    }

    public String getStoId() {
        return stoId;
    }

    public void setStoId(String stoId) {
        this.stoId = stoId;
    }
    
    
    
    
    
}
