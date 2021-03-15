package com.myspring.lmm.intro.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.lmm.intro.vo.IntroVO;
import com.myspring.lmm.intro.vo.StoreBoardVO;

@Repository("introDAO")
public class IntroDAOImpl implements IntroDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllArticlesList() throws DataAccessException {
		List<IntroVO> articlesList = articlesList = sqlSession.selectList("mapper.intro.selectAllArticlesList");
		return articlesList;
	}

	
	@Override
	public int insertNewArticle(Map articleMap) throws DataAccessException {
		int articleNO = selectNewArticleNO();
		articleMap.put("siNo", articleNO);
		sqlSession.insert("mapper.intro.insertNewArticle",articleMap);
		return articleNO;
	}
    
	//다중 파일 업로드
	/*
	@Override
	public void insertNewImage(Map articleMap) throws DataAccessException {
		List<StoreintroVO> imageFileList = (ArrayList)articleMap.get("imageFileList");
		int articleNO = (Integer)articleMap.get("articleNO");
		int imageFileNO = selectNewImageFileNO();
		for(StoreBoardVO imageVO : imageFileList){
			imageVO.setImageFileNO(++imageFileNO);
			imageVO.setArticleNO(articleNO);
		}
		sqlSession.insert("mapper.intro.insertNewImage",imageFileList);
	}
	
   */
	
	@Override
	public IntroVO selectArticle(int articleNO) throws DataAccessException {
		return sqlSession.selectOne("mapper.intro.selectArticle", articleNO);
	}

	@Override
	public void updateArticle(Map articleMap) throws DataAccessException {
		sqlSession.update("mapper.intro.updateArticle", articleMap);
	}

	@Override
	public void deleteArticle(int siNo) throws DataAccessException {
		sqlSession.delete("mapper.intro.deleteArticle", siNo);
		
	}
	
	@Override
	public List selectImageFileList(int articleNO) throws DataAccessException {
		List<StoreBoardVO> imageFileList = null;
		imageFileList = sqlSession.selectList("mapper.intro.selectImageFileList",articleNO);
		return imageFileList;
	}
	
	private int selectNewArticleNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.intro.selectNewArticleNO");
	}
	
	private int selectNewImageFileNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.intro.selectNewImageFileNO");
	}

}