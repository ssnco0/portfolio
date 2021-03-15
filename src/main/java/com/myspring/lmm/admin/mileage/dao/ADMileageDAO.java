package com.myspring.lmm.admin.mileage.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.lmm.admin.member.vo.ADMemberVO;

public interface ADMileageDAO {
	 public List selectAllMileage() throws DataAccessException;

	public List SelectMilById(String cusid, int select);

	public List SelectAllStoreMileage();

	public List StoMileageById(String search,int select);
}
