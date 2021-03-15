package com.myspring.lmm.admin.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.lmm.admin.member.vo.ADMemberVO;
import com.myspring.lmm.admin.member.vo.ManagerVO;

public interface ADMemberService {
	 public List listMembers() throws DataAccessException;
	 public int addMember(ADMemberVO memberVO) throws DataAccessException;
	 public int removeMember(String stoid) throws DataAccessException;
//	 public ADMemberVO login(ADMemberVO memberVO) throws Exception;
	 public List StoreMembers(String stoid,int select) throws DataAccessException;
	 public List SelectUserMileage(String cusid) throws DataAccessException;
	 public List StorelistMembers() throws DataAccessException;
	 public List CusMembers(String cusid);
	 public void approve(String stoid);
	 public int removeCusUserById(String cusid) throws DataAccessException;
	 public List sumhome();

//	 public ManagerVO login(Map loginMap) throws Exception;
//	 public List<ManagerVO> login(String manId, String manPassword, String manAuthority) throws Exception;
	 public ManagerVO login(ManagerVO managerVO) throws Exception;
}
