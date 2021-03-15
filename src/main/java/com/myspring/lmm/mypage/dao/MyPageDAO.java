package com.myspring.lmm.mypage.dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.lmm.member.vo.MemberVO;

public interface MyPageDAO {


	public MemberVO selectMyDetailInfo(String cusId) throws DataAccessException;
	public void memberUpdate(MemberVO memberVO) throws Exception;


}