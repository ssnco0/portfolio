package com.myspring.lmm.admin.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.lmm.admin.member.dao.ADMemberDAO;
import com.myspring.lmm.admin.member.vo.ADMemberVO;
import com.myspring.lmm.admin.member.vo.ManagerVO;


@Service("ADmemberService")
@Transactional(propagation = Propagation.REQUIRED)
public class ADMemberServiceImpl implements ADMemberService {
	@Autowired
	private ADMemberDAO memberDAO;

	@Override
	public List listMembers() throws DataAccessException {
		List membersList = null;
		membersList = memberDAO.selectAllMemberList();
		return membersList;
	}
	
	@Override
	public List StorelistMembers() throws DataAccessException {
		List membersList = null;
		membersList = memberDAO.selectAllStoreMemberList();
		return membersList;
	}

	@Override
	public int addMember(ADMemberVO member) throws DataAccessException {
		return memberDAO.insertMember(member);
	}

	@Override
	public int removeMember(String stoid) throws DataAccessException {
		return memberDAO.deleteMember(stoid);
	}
	
	@Override
	public int removeCusUserById(String cusid) throws DataAccessException {
		return memberDAO.removeCusUserById(cusid);
	}
	

//	@Override
//	public List<ManagerVO> login(String manId, String manPassword, String manAuthority) throws Exception{
//	    List managerList = null;
//	    managerList = memberDAO.login(manId,manPassword,manAuthority);
//		return managerList;
//	}
	@Override
	public ManagerVO login(ManagerVO managerVO) throws Exception{
		return memberDAO.login(managerVO);
	}


	@Override
	public List StoreMembers(String stoid,int select) throws DataAccessException {
		List membersList = null;
		membersList = memberDAO.StoreMember(stoid,select);
		return membersList;
	}
	
	@Override
	public List SelectUserMileage(String cusid) throws DataAccessException {
		List membersList = null;
		membersList = memberDAO.SelectUserMileage(cusid);
		return membersList;
	}

	@Override
	public List CusMembers(String cusid) {
		List membersList = null;
		membersList = memberDAO.CusMember(cusid);
		return membersList;
	}

	@Override
	public void approve(String stoid) {
		memberDAO.approve(stoid);
		
	}

	@Override
	public List sumhome() {
		List membersList = memberDAO.sumhome();
		return membersList;
	}

}
