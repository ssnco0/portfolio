package com.myspring.lmm.ntc.service;

import java.util.List;
import java.util.Map;

import com.myspring.lmm.ntc.vo.NtcVO;

public interface NtcService {
	
	public List<NtcVO> listArticles() throws Exception;
	public int addNewArticle(Map articleMap) throws Exception;
	public NtcVO viewArticle(int articleNO) throws Exception;
	//public Map viewArticle(int articleNO) throws Exception;
	public void modArticle(Map articleMap) throws Exception;
	public void removeArticle(int articleNO) throws Exception;

}
