
package com.myspring.lmm.mystopage.service;

import com.myspring.lmm.store.vo.StoreVO;

public interface MyStoreService {

	public StoreVO myStorePage(String stoId) throws Exception;
	public void storeUpdate(StoreVO storeVO) throws Exception;




}
