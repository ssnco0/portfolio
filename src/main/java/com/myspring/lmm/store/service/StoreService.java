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
	
	//�̸��Ϲ߼�
	public void sendEmail(StoreVO storeVO, String div) throws Exception;
	//��й�ȣã��
	public void findpw(HttpServletResponse response, StoreVO storeVO) throws Exception;
	//���̵�ã��
	public String findid(HttpServletResponse response, String email) throws Exception;
	
	//�׽�
	public int addScImg(Map scMap) throws Exception;
	
	
	
	
}
