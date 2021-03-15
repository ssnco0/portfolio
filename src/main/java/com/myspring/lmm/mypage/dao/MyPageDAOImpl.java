package com.myspring.lmm.mypage.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.lmm.member.vo.MemberVO;
@Repository("myPageDAO")
public class MyPageDAOImpl implements MyPageDAO{
	@Autowired
	private SqlSession sqlSession;


	
	public MemberVO selectMyDetailInfo(String cusId) throws DataAccessException{
		MemberVO memberVO=(MemberVO)sqlSession.selectOne("mapper.member.selectMyDetailInfo",cusId);
		return memberVO;
		
	}
	// 내 정보 수정
	@Override
	public void memberUpdate(MemberVO memberVO) throws Exception {
	    sqlSession.update("mapper.member.memberUpdate", memberVO);
	}

}
