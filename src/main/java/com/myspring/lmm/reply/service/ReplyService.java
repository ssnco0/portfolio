package com.myspring.lmm.reply.service;

import java.util.List;
import java.util.Map;

import com.myspring.lmm.qna.vo.QnaVO;
import com.myspring.lmm.reply.vo.ReplyVO;

public interface ReplyService {
	
	
	public List<ReplyVO> listArticles(int articleNO) throws Exception;
	public int addNewArticle(Map articleMap) throws Exception;
	//public ReplyVO viewArticle(int articleNO) throws Exception;
	//public Map viewArticle(int articleNO) throws Exception;
	public void modArticle(Map articleMap) throws Exception;
	public void removeArticle(int articleNO) throws Exception;
}
