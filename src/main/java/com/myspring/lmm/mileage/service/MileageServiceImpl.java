package com.myspring.lmm.mileage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.lmm.mileage.dao.MileageDAO;
import com.myspring.lmm.mileage.vo.MileageVO;
import com.myspring.lmm.payment.vo.PaymentVO;



@Service("mileageService")
@Transactional(propagation = Propagation.REQUIRED)
public class MileageServiceImpl implements MileageService {
	@Autowired
	private MileageDAO mileageDAO;
	
	@Override
	public List<MileageVO> stackMileages(String cusId) throws DataAccessException {
		List<MileageVO> stackMil = null;	
		stackMil = mileageDAO.selectStackMileage(cusId);
		return stackMil;
	}
	
	@Override
	public List<PaymentVO> useMileages(String cusId) throws DataAccessException {
		List<PaymentVO> useMil = null;	
		useMil = mileageDAO.selectUseMileage(cusId);
		return useMil;
	}

}
