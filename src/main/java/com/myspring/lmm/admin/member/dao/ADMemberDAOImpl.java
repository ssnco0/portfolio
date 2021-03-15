package com.myspring.lmm.admin.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.lmm.admin.member.vo.ADMemberVO;
import com.myspring.lmm.admin.member.vo.ManagerVO;

@Repository("ADmemberDAO")
public class ADMemberDAOImpl implements ADMemberDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllMemberList() throws DataAccessException {
		List<ADMemberVO> membersList = null;
		membersList = sqlSession.selectList("mapper.admin.member.selectAllMemberList");
		return membersList;
	}
	
	@Override
	public List selectAllStoreMemberList() throws DataAccessException {
		List<ADMemberVO> membersList = null;
		membersList = sqlSession.selectList("mapper.admin.member.selectAllStoreMemberList");
		return membersList;
	}

	@Override
	public int insertMember(ADMemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.admin.member.insertMember", memberVO);
		return result;
	}

	@Override
	public int removeCusUserById(String cusid) throws DataAccessException {
		int result = sqlSession.delete("mapper.admin.member.removeCusUserById", cusid);
		return result;
	}
	
	@Override
	public int deleteMember(String stoid) throws DataAccessException {
		int result = sqlSession.delete("mapper.admin.member.deleteMember", stoid);
		return result;
	}


	//로그인
	@Override
	public ManagerVO login(ManagerVO managerVO) throws DataAccessException{
	    ManagerVO vo = sqlSession.selectOne("mapper.admin.member.login",managerVO);
		return vo;
	}
//	@Override
//	public List<ManagerVO> login(String manId, String manPassword, String manAuthority) throws Exception{
//	    List managerList = null;
//	    managerList = memberDAO.login(manId,manPassword,manAuthority);
//		return managerList;
//	}
	
	
	@Override
	public List StoreMember(String stoid,int select) throws DataAccessException {
		List<ADMemberVO> membersList = null;
		System.out.println("stoid dao:"+stoid);
		System.out.println("select dao:"+select);
		
		//아이디값 입력없이 쿼리
		if(stoid == null || stoid.isEmpty()) {
			if(select == 0) {
				membersList = sqlSession.selectList("mapper.admin.member.selectAllStoreMemberList");
			}
			else if(select == 1) {
				membersList = sqlSession.selectList("mapper.admin.member.selectAppStoreMemberList");
			}
			else {
				membersList = sqlSession.selectList("mapper.admin.member.selectNotAppStoreMemberList");
			}
		}
		else {
			if(select == 0) {
				membersList = sqlSession.selectList("mapper.admin.member.selectAllStoreByStoid",stoid);
			}
			else if(select == 1) {
				membersList = sqlSession.selectList("mapper.admin.member.selectAppStoreByStoid",stoid);
			}
			else{
				membersList = sqlSession.selectList("mapper.admin.member.selectNotAppStoreByStoid",stoid);
			}
		}
		return membersList;
	}
	
	@Override
	public List SelectUserMileage(String cusid) throws DataAccessException {
		List<ADMemberVO> membersList = null;
		membersList = sqlSession.selectList("mapper.admin.member.selectUserMileage");
		return membersList;
	}

	@Override
	public List CusMember(String cusid) {
		List<ADMemberVO> membersList = null;
		System.out.println("sql/cusid:"+cusid);
		membersList = sqlSession.selectList("mapper.admin.member.selectCusMember",cusid);
		return membersList;
	}

	@Override
	public void approve(String stoid) {
		sqlSession.update("mapper.admin.member.approve",stoid);
		
	}

	@Override
	public List sumhome() {
		List membersList = sqlSession.selectList("mapper.admin.member.sumhome");
		return membersList;
	}



}
