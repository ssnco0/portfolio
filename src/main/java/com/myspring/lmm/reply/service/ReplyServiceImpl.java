package com.myspring.lmm.reply.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.myspring.lmm.reply.dao.ReplyDAO;
import com.myspring.lmm.reply.vo.ReplyVO;


@Repository("replyService")
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	ReplyDAO boardDAO;
		
	//답글쓰기
	@Override
	public int addNewArticle(Map replyMap) throws Exception{
		return boardDAO.insertNewArticle(replyMap);
	}	
	public List<ReplyVO> listArticles(int articleNO) throws Exception{
		List<ReplyVO> replysList =  boardDAO.selectAllArticlesList(articleNO);
        return replysList;
	}

	
//	 //단일 파일 보이기
//	@Override
//	public ReplyVO viewArticle(int articleNO) throws Exception {
//		ReplyVO articleVO = boardDAO.selectArticle(articleNO);
//		return articleVO;
//	}
//	
	
	@Override
	public void modArticle(Map replyMap) throws Exception {
		boardDAO.updateArticle(replyMap);
	}
	
	@Override
	public void removeArticle(int articleNO) throws Exception {
		boardDAO.deleteArticle(articleNO);
	}
		

}
