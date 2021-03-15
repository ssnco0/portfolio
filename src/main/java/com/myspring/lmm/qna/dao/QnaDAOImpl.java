package com.myspring.lmm.qna.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.lmm.qna.vo.QnaVO;


@Repository("qnaDAO")
public class QnaDAOImpl implements QnaDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllArticlesList() throws DataAccessException {
		List<QnaVO> articlesList = sqlSession.selectList("mapper.qna.selectAllArticlesList");
		return articlesList;
	}

	
	@Override
	public int insertNewArticle(Map articleMap) throws DataAccessException {
		int ArticleNO = selectNewArticleNO();
		articleMap.put("qnaNo", ArticleNO);
		sqlSession.insert("mapper.qna.insertNewArticle",articleMap);
		return ArticleNO;
	}
    
	//다중 파일 업로드
	/*
	@Override
	public void insertNewImage(Map articleMap) throws DataAccessException {
		List<ImageVO> imageFileList = (ArrayList)articleMap.get("imageFileList");
		int articleNO = (Integer)articleMap.get("articleNO");
		int imageFileNO = selectNewImageFileNO();
		for(ImageVO imageVO : imageFileList){
			imageVO.setImageFileNO(++imageFileNO);
			imageVO.setArticleNO(articleNO);
		}
		sqlSession.insert("mapper.qna.insertNewImage",imageFileList);
	}
	
   */
	
	@Override
	public QnaVO selectArticle(int articleNO) throws DataAccessException {
		return sqlSession.selectOne("mapper.qna.selectArticle", articleNO);
	}

	@Override
	public void updateArticle(Map articleMap) throws DataAccessException {
		sqlSession.update("mapper.qna.updateArticle", articleMap);
	}

	@Override
	public void deleteArticle(int qnaNo) throws DataAccessException {
		sqlSession.delete("mapper.qna.deleteArticle", qnaNo);
		
	}
	

	
	private int selectNewArticleNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.qna.selectNewArticleNO");
	}
	
	
}
