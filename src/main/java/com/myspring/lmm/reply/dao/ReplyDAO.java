package com.myspring.lmm.reply.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.lmm.qna.vo.QnaVO;
import com.myspring.lmm.reply.vo.ReplyVO;

public interface ReplyDAO {
	
	
	public int insertNewArticle(Map replyMap) throws DataAccessException;
	//public void insertNewImage(Map articleMap) throws DataAccessException;
	public List selectAllArticlesList(int articleNO) throws DataAccessException;
	//public ReplyVO selectArticle(int articleNO) throws DataAccessException;
	public void updateArticle(Map replyMap) throws DataAccessException;
	public void deleteArticle(int qnaNo) throws DataAccessException;
	
}
	
