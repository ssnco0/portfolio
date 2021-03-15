package com.myspring.lmm.store.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.myspring.lmm.store.vo.StoreVO;

public interface StoreService {
    	public StoreVO login(StoreVO storeVO) throws Exception;
//	public StoreVO login(Map  loginMap) throws Exception;
	public void addStore(StoreVO storeVO) throws Exception;
	public String overlapped(String id) throws Exception;
	public String overlappedPh(String phone) throws Exception;
	public String overlappedEm(String email) throws Exception;
	
	//이메일발송
	public void sendEmail(StoreVO storeVO, String div) throws Exception;
	//비밀번호찾기
	public void findpw(HttpServletResponse response, StoreVO storeVO) throws Exception;
	//아이디찾기
	public String findid(HttpServletResponse response, String email) throws Exception;
	
	//테슷
	public int addScImg(Map scMap) throws Exception;
	
	
	
	
}
