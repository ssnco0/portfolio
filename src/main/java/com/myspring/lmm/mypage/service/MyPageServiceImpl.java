package com.myspring.lmm.mypage.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.lmm.member.vo.MemberVO;
import com.myspring.lmm.mypage.dao.MyPageDAO;

@Service("myPageService")
@Transactional(propagation=Propagation.REQUIRED)
public class MyPageServiceImpl  implements MyPageService{
	@Autowired
	private MyPageDAO myPageDAO;

	public MemberVO myDetailInfo(String cusId) throws Exception{
		return myPageDAO.selectMyDetailInfo(cusId);
	}
	
	// 회원수정
	@Override
	public void memberUpdate(MemberVO memberVO) throws Exception {
	    myPageDAO.memberUpdate(memberVO);
	}
	
}