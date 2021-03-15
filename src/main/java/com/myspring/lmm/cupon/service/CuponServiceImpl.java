package com.myspring.lmm.cupon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.lmm.cupon.dao.CuponDAO;
import com.myspring.lmm.cupon.vo.CuponVO;
import com.myspring.lmm.member.vo.MemberVO;

@Service("cuponService")
@Transactional(propagation = Propagation.REQUIRED)
public class CuponServiceImpl implements CuponService {
	@Autowired
	private CuponDAO cuponDAO;
	
	
	// ���� ��ȸ -������
	@Override
	public List listCupons(String stoId) throws DataAccessException {
		List<CuponVO> cuponsList = null;
		cuponsList = cuponDAO.selectAllCuponList(stoId);
		return cuponsList;
	}
	
	// ���� ��ȸ -�����
	@Override
	public List cuscuponList(String cusId) throws DataAccessException {
		List<CuponVO> cuscuponList = null;
		cuscuponList = cuponDAO.selectCusCuponList(cusId);
		return cuscuponList;
	}
	
	
	@Override
	public List listCupons2(CuponVO cuponVO) throws DataAccessException {
		List cuponsList2 = null;
		cuponsList2 = cuponDAO.selectTransCuponList(cuponVO);
		return cuponsList2;
	}

	@Override
	public int addCupon(CuponVO cupon) throws DataAccessException {
		return cuponDAO.insertCupon(cupon);
	}
	
	// �׽�Ʈ
	@Override
	public List<MemberVO> listCupons4() throws DataAccessException {
		List<MemberVO> cuponsList4 = null;
		cuponsList4 = cuponDAO.selectAllCuponList4();
		return cuponsList4;
	}
	

	

}
