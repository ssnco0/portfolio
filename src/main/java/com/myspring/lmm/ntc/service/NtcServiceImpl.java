package com.myspring.lmm.ntc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myspring.lmm.ntc.dao.NtcDAO;
import com.myspring.lmm.ntc.vo.NtcVO;

@Repository("ntcService")
public class NtcServiceImpl implements NtcService{
	@Autowired
	NtcDAO boardDAO;
	
	public List<NtcVO> listArticles() throws Exception{
		List<NtcVO> articlesList =  boardDAO.selectAllArticlesList();
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
	public NtcVO viewArticle(int articleNO) throws Exception {
		NtcVO articleVO = boardDAO.selectArticle(articleNO);
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
