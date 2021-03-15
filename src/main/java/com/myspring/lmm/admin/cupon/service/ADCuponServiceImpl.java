package com.myspring.lmm.admin.cupon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.lmm.admin.cupon.dao.ADCuponDAO;
import com.myspring.lmm.admin.mileage.dao.ADMileageDAO;


@Service("ADcuponService")
@Transactional(propagation = Propagation.REQUIRED)
public class ADCuponServiceImpl implements ADCuponService {
	@Autowired
	private ADCuponDAO cuponDAO;
	
	@Override
	public List SelectNoAppCupon() throws DataAccessException {
		List cuponList = null;
		cuponList = cuponDAO.SelectNoAppCupon();
		return cuponList;
	}

	@Override
	public void StoreCuponApp(String cupid) {
		cuponDAO.StoreCuponApp(cupid);	
	}

	@Override
	public List SearchCuponByCupQRNo(String search, int select) {
		List cuponList = null;
		cuponList = cuponDAO.SearchCuponByCupQRNo(search,select);
		return cuponList;
	}

	@Override
	public List SearchUseCupon(String search, int select) {
		List cuponList = null;
		cuponList = cuponDAO.SearchUseCupon(search,select);
		return cuponList;
	}

}
