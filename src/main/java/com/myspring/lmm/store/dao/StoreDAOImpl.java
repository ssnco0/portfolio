package com.myspring.lmm.store.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.lmm.store.vo.StoreVO;

@Repository("storeDAO")
public class StoreDAOImpl implements StoreDAO {
	@Autowired
	private SqlSession sqlSession;
		
	
	@Override
	public StoreVO login(StoreVO storeVO) throws DataAccessException{
	    StoreVO store=(StoreVO)sqlSession.selectOne("mapper.store.login",storeVO);
	   return store;
	}
	
	@Override
	public void insertStore(StoreVO storeVO) throws DataAccessException{
		sqlSession.insert("mapper.store.insertStore", storeVO);
	}

	@Override
	public String selectOverlappedID(String id) throws DataAccessException {
		String result =  sqlSession.selectOne("mapper.store.selectOverlappedID",id);
		return result;
	}
	@Override
	public String selectOverlappedPhone(String phone) throws DataAccessException {
		String result =  sqlSession.selectOne("mapper.store.selectOverlappedPhone",phone);
		return result;
	}
	@Override
	public String selectOverlappedEmail(String email) throws DataAccessException {
		String result =  sqlSession.selectOne("mapper.store.selectOverlappedEmail",email);
		return result;
	}
	
	// 아이디 찾기
	public String findid(String email) throws Exception{
		return sqlSession.selectOne("mapper.store.findid", email);
	}
	// 비밀번호 찾기 ( 임시번호 )
	@Transactional
	@Override
	public int update_pw(StoreVO storeVO) throws Exception{
		return sqlSession.update("mapper.store.update_pw", storeVO);
	}
	@Override
	public int insertNewScImg(Map scMap) throws DataAccessException {
		int scNo = selectNewImageFileNO();
		scMap.put("scNo", scNo);
		sqlSession.insert("mapper.store.insertNewScImg",scMap);
		return scNo;
	}

	public int selectNewImageFileNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.store.selectNewImageFileNO");
	}

	
}
