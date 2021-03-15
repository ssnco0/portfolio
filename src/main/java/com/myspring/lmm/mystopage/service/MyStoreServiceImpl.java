
package com.myspring.lmm.mystopage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.lmm.member.vo.MemberVO;
import com.myspring.lmm.mystopage.dao.MyStoreDAO;
import com.myspring.lmm.store.vo.StoreVO;

@Service("myStoreService")
@Transactional(propagation=Propagation.REQUIRED)
public class MyStoreServiceImpl  implements MyStoreService{
	@Autowired
	private MyStoreDAO myStoreDAO;

	public StoreVO myStorePage(String stoId) throws Exception{
		return myStoreDAO.selectMyStorePage(stoId);
	}

	// 회원수정
	@Override
	public void storeUpdate(StoreVO storeVO) throws Exception {
	    	myStoreDAO.storeUpdate(storeVO);
	}
	
	
}