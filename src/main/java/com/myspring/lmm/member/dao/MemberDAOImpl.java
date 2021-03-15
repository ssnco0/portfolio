package com.myspring.lmm.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.lmm.member.vo.MemberVO;


@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertMember(MemberVO memberVO) throws DataAccessException{
		sqlSession.insert("mapper.member.insertMember",memberVO);
	}

	@Override
	public MemberVO login(Map loginMap) throws DataAccessException{
		MemberVO member=(MemberVO)sqlSession.selectOne("mapper.member.login",loginMap);
	   return member;
	}

	@Override
	public String selectOverlappedID(String id) throws DataAccessException {
		String result =  sqlSession.selectOne("mapper.member.selectOverlappedID",id);
		return result;
	}
	@Override
	public String selectOverlappedPhone(String phone) throws DataAccessException {
		String result =  sqlSession.selectOne("mapper.member.selectOverlappedPhone",phone);
		return result;
	}
	@Override
	public String selectOverlappedEmail(String email) throws DataAccessException {
		String result =  sqlSession.selectOne("mapper.member.selectOverlappedEmail",email);
		return result;
	}
	
	// 아이디 찾기
	public String findid(String email) throws Exception{
		return sqlSession.selectOne("mapper.member.findid", email);
	}
	
	// 비밀번호 찾기 ( 임시번호 )
	@Transactional
	@Override
	public int update_pw(MemberVO memberVO) throws Exception{
		return sqlSession.update("mapper.member.update_pw", memberVO);
	}
		

//
//	// 이메일 인증
//	@Transactional
//	@Override
//	public int approval_member(MemberVO vo) throws Exception {
//		return sqlSession.update("mapper.member.approval_member", vo);
//	}

}
