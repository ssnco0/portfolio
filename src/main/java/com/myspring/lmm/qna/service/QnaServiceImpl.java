package com.myspring.lmm.qna.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myspring.lmm.qna.dao.QnaDAO;
import com.myspring.lmm.qna.vo.QnaVO;

@Repository("qnaService")
public class QnaServiceImpl implements QnaService{
	@Autowired
	QnaDAO boardDAO;
	
	public List<QnaVO> listArticles() throws Exception{
		List<QnaVO> articlesList =  boardDAO.selectAllArticlesList();
        return articlesList;
	}

	
	//���� �̹��� �߰��ϱ�
	@Override
	public int addNewArticle(Map articleMap) throws Exception{
		return boardDAO.insertNewArticle(articleMap);
	}
	
	 //���� �̹��� �߰��ϱ�
	/*
	@Override
	public int addNewArticle(Map articleMap) throws Exception{
		int articleNO = boardDAO.insertNewArticle(articleMap);
		articleMap.put("articleNO", articleNO);
		boardDAO.insertNewImage(articleMap);
		return articleNO;
	}
	*/
	/*
	//���� ���� ���̱�
	@Override
	public Map viewArticle(int articleNO) throws Exception {
		Map articleMap = new HashMap();
		ArticleVO articleVO = boardDAO.selectArticle(articleNO);
		List<ImageVO> imageFileList = boardDAO.selectImageFileList(articleNO);
		articleMap.put("article", articleVO);
		articleMap.put("imageFileList", imageFileList);
		return articleMap;
	}
   */
	
	
	 //���� ���� ���̱�
	@Override
	public QnaVO viewArticle(int articleNO) throws Exception {
		QnaVO articleVO = boardDAO.selectArticle(articleNO);
		return articleVO;
	}
	
	
	@Override
	public void modArticle(Map articleMap) throws Exception {
		boardDAO.updateArticle(articleMap);
	}
	
	@Override
	public void removeArticle(int articleNO) throws Exception {
		boardDAO.deleteArticle(articleNO);
	}
	

	
}
