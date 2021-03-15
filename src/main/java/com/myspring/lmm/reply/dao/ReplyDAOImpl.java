package com.myspring.lmm.reply.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.lmm.qna.vo.QnaVO;
import com.myspring.lmm.reply.vo.ReplyVO;

@Repository("replyDAO")
public class ReplyDAOImpl implements ReplyDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertNewArticle(Map replyMap) throws DataAccessException {
		int ArticleNO = selectNewArticleNO();
		replyMap.put("reNo", ArticleNO);	
		sqlSession.insert("mapper.reply.insertNewArticle",replyMap);
		return ArticleNO;
	}
   
	@Override
	public List selectAllArticlesList(int articleNO) throws DataAccessException {
		List<ReplyVO> replysList = sqlSession.selectList("mapper.reply.selectAllArticlesList", articleNO);
		return replysList;
	}
	
//	@Override
//	public ReplyVO selectArticle(int articleNO) throws DataAccessException {
//		return sqlSession.selectOne("mapper.reply.selectArticle", articleNO);
//	}

	@Override
	public void updateArticle(Map replyMap) throws DataAccessException {
		sqlSession.update("mapper.reply.updateArticle", replyMap);
	}

	@Override
	public void deleteArticle(int qnaNo) throws DataAccessException {
		sqlSession.delete("mapper.reply.deleteArticle", qnaNo);
		
	}
	
	private int selectNewArticleNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.reply.selectNewArticleNO");
	}
	
	
}