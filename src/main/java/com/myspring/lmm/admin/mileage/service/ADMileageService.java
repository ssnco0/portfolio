package com.myspring.lmm.admin.mileage.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.lmm.admin.member.vo.ADMemberVO;

public interface ADMileageService {

	public List selectAllMileage() throws DataAccessException;

	public List SelectMilById(String cusid,int select);

	public List SelectAllStoreMileage();

	public List StoMileageById(String search,int select);

}
