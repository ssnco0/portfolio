package com.myspring.lmm.admin.member.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.lmm.admin.member.vo.ADMemberVO;
import com.myspring.lmm.admin.member.vo.ManagerVO;

public interface ADMemberDAO {
	public List selectAllMemberList() throws DataAccessException;
	public int insertMember(ADMemberVO memberVO) throws DataAccessException ;
	public int deleteMember(String stoid) throws DataAccessException;

	public List SelectUserMileage(String cusid) throws DataAccessException;
	public List StoreMember(String stoid,int select) throws DataAccessException;
	public List selectAllStoreMemberList() throws DataAccessException;
	public List CusMember(String cusid);
	public void approve(String stoid);
	public int removeCusUserById(String cusid) throws DataAccessException;
	public List sumhome();

//	public ManagerVO login(Map loginMap) throws DataAccessException;
//	public List<ManagerVO> login(String manId, String manPassword, String manAuthority) throws DataAccessException;
	public ManagerVO login(ManagerVO managerVO) throws DataAccessException;

}
