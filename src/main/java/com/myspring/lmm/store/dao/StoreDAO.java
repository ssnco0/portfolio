package com.myspring.lmm.store.dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.lmm.store.vo.StoreVO;

public interface StoreDAO {
    	public StoreVO login(StoreVO storeVO) throws DataAccessException;
    	public void insertStore(StoreVO storeVO) throws DataAccessException;
//	public StoreVO login(Map loginMap) throws DataAccessException;
	
	//�ߺ��˻�
	public String selectOverlappedID(String id) throws DataAccessException;
	public String selectOverlappedPhone(String phone) throws DataAccessException;
	public String selectOverlappedEmail(String email) throws DataAccessException;
	
	//ã��
	public String findid(String email) throws Exception;
	public int update_pw(StoreVO storeVO) throws Exception;
	
	//�׽�
	
//	int selectNewScNO(Map scMap) throws DataAccessException;
//	int selectNewScNO() throws DataAccessException;
	public int insertNewScImg(Map scMap);
	int selectNewImageFileNO() throws DataAccessException;
	
}
