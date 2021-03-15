package com.myspring.lmm.admin.mileage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.lmm.admin.mileage.dao.ADMileageDAO;


@Service("ADmileageService")
@Transactional(propagation = Propagation.REQUIRED)
public class ADMileageServiceImpl implements ADMileageService {
	@Autowired
	private ADMileageDAO mileageDAO;
	
	@Override
	public List selectAllMileage() throws DataAccessException {
		List mileageList = null;
		mileageList = mileageDAO.selectAllMileage();
		return mileageList;
	}

	@Override
	public List SelectMilById(String cusid,int select) {
		List mileageList = null;
		mileageList = mileageDAO.SelectMilById(cusid,select);
		return mileageList;
	}

	@Override
	public List SelectAllStoreMileage() {
		List StoremileageList = null;
		StoremileageList = mileageDAO.SelectAllStoreMileage();
		return StoremileageList;
	}

	@Override
	public List StoMileageById(String search,int select) {
		List StoremileageList = mileageDAO.StoMileageById(search,select);
		return StoremileageList;
	}

}
