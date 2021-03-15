package com.myspring.lmm.mileage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.lmm.mileage.vo.MileageVO;
import com.myspring.lmm.payment.vo.PaymentVO;


@Repository("mileageDAO")
public class MileageDAOImpl implements MileageDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<MileageVO> selectStackMileage(String cusId) throws DataAccessException {
		List<MileageVO> stackMil = null;
		stackMil = sqlSession.selectList("mapper.mileage.selectStackMileage",cusId);
		return stackMil;
	}
	
	@Override
	public List<PaymentVO> selectUseMileage(String cusId) throws DataAccessException {
		List<PaymentVO> useMil = null;
		useMil = sqlSession.selectList("mapper.payment.selectUseMileage",cusId);
		return useMil;
	}

	
}
