package com.myspring.lmm.member.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;

import com.myspring.lmm.member.vo.MemberVO;

public interface MemberService {
	 
		public MemberVO login(Map  loginMap) throws Exception;
		public void addMember(MemberVO memberVO) throws Exception;
		public String overlapped(String id) throws Exception;
		public String overlappedPh(String phobe) throws Exception;
		public String overlappedEm(String email) throws Exception;
		
		//이메일발송
		public void sendEmail(MemberVO memberVO, String div) throws Exception;
		//비밀번호찾기
		public void findpw(HttpServletResponse response, MemberVO memberVO) throws Exception;
		//아이디찾기
		public String findid(HttpServletResponse response, String email) throws Exception;

	}
