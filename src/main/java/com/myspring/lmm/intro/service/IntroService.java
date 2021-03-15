package com.myspring.lmm.intro.service;

import java.util.List;
import java.util.Map;

import com.myspring.lmm.intro.vo.IntroVO;

public interface IntroService {
	
	public List<IntroVO> listArticles() throws Exception;
	public int addNewArticle(Map articleMap) throws Exception;
	public IntroVO viewArticle(int articleNO) throws Exception;
	//public Map viewArticle(int articleNO) throws Exception;
	public void modArticle(Map articleMap) throws Exception;
	public void removeArticle(int articleNO) throws Exception;

}
