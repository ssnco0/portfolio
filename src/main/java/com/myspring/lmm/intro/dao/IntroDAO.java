package com.myspring.lmm.intro.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.lmm.intro.vo.IntroVO;
import com.myspring.lmm.intro.vo.StoreBoardVO;

public interface IntroDAO {

	public List<IntroVO> selectAllArticlesList() throws DataAccessException;
	public int insertNewArticle(Map articleMap) throws DataAccessException;
	//public void insertNewImage(Map articleMap) throws DataAccessException;
	
	public IntroVO selectArticle(int articleNO) throws DataAccessException;
	public void updateArticle(Map articleMap) throws DataAccessException;
	public void deleteArticle(int siNo) throws DataAccessException;
	public List selectImageFileList(int articleNO) throws DataAccessException;
}
