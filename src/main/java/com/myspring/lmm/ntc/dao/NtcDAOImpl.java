package com.myspring.lmm.ntc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.lmm.ntc.vo.NtcVO;


@Repository("ntcDAO")
public class NtcDAOImpl implements NtcDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllArticlesList() throws DataAccessException {
		List<NtcVO> articlesList = articlesList = sqlSession.selectList("mapper.ntc.selectAllArticlesList");
		return articlesList;
	}

	
	@Override
	public int insertNewArticle(Map articleMap) throws DataAccessException {
		int articleNO = selectNewArticleNO();
		articleMap.put("ntcNo", articleNO);
		sqlSession.insert("mapper.ntc.insertNewArticle",articleMap);
		return articleNO;
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
		sqlSession.insert("mapper.ntc.insertNewImage",imageFileList);
	}
	
   */
	
	@Override
	public NtcVO selectArticle(int articleNO) throws DataAccessException {
		return sqlSession.selectOne("mapper.ntc.selectArticle", articleNO);
	}

	@Override
	public void updateArticle(Map articleMap) throws DataAccessException {
		sqlSession.update("mapper.ntc.updateArticle", articleMap);
	}

	@Override
	public void deleteArticle(int ntcNo) throws DataAccessException {
		sqlSession.delete("mapper.ntc.deleteArticle", ntcNo);
		
	}

	
	private int selectNewArticleNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.ntc.selectNewArticleNO");
	}
	
	
}