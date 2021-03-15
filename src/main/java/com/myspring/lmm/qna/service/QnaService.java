package com.myspring.lmm.qna.service;

import java.util.List;
import java.util.Map;

import com.myspring.lmm.qna.vo.QnaVO;

public interface QnaService {
	public List<QnaVO> listArticles() throws Exception;
	public int addNewArticle(Map articleMap) throws Exception;
	public QnaVO viewArticle(int articleNO) throws Exception;
	//public Map viewArticle(int articleNO) throws Exception;
	public void modArticle(Map articleMap) throws Exception;
	public void removeArticle(int articleNO) throws Exception;
}
