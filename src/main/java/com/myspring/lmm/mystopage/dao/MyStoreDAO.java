package com.myspring.lmm.mystopage.dao;

import org.springframework.dao.DataAccessException;

import com.myspring.lmm.store.vo.StoreVO;

public interface MyStoreDAO {


	public StoreVO selectMyStorePage(String stoId) throws DataAccessException;

	public void storeUpdate(StoreVO storeVO) throws Exception;
}