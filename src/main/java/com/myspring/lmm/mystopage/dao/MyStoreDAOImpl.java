package com.myspring.lmm.mystopage.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.lmm.store.vo.StoreVO;
@Repository("myStoreDAO")
public class MyStoreDAOImpl implements MyStoreDAO{
	@Autowired
	private SqlSession sqlSession;


	
	public StoreVO selectMyStorePage(String stoId) throws DataAccessException{
	    StoreVO storeVO=(StoreVO)sqlSession.selectOne("mapper.store.selectMyStorePage",stoId);
		return storeVO;
	}
	// 내 정보 수정
	@Override
	public void storeUpdate(StoreVO storeVO) throws Exception {
	    sqlSession.update("mapper.store.storeUpdate", storeVO);
	}

}
