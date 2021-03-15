package com.myspring.lmm.member.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.lmm.member.vo.MemberVO;


public interface MemberDAO {
	public void insertMember(MemberVO memberVO) throws DataAccessException;
	public MemberVO login(Map loginMap) throws DataAccessException;
	
	//중복검사
	public String selectOverlappedID(String id) throws DataAccessException;
	public String selectOverlappedPhone(String phone) throws DataAccessException;
	public String selectOverlappedEmail(String email) throws DataAccessException;
	
	//찾기
	public String findid(String email) throws Exception;
	public int update_pw(MemberVO memberVO) throws Exception;
	

}
