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
		
		//�̸��Ϲ߼�
		public void sendEmail(MemberVO memberVO, String div) throws Exception;
		//��й�ȣã��
		public void findpw(HttpServletResponse response, MemberVO memberVO) throws Exception;
		//���̵�ã��
		public String findid(HttpServletResponse response, String email) throws Exception;

	}
