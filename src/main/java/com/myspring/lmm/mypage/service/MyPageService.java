package com.myspring.lmm.mypage.service;

import com.myspring.lmm.member.vo.MemberVO;

public interface MyPageService {

	public MemberVO myDetailInfo(String cusId) throws Exception;

	public void memberUpdate(MemberVO memberVO) throws Exception;
}
