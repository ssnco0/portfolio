package com.myspring.lmm.payment.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.lmm.cupon.vo.CuponVO;
import com.myspring.lmm.member.vo.MemberVO;
import com.myspring.lmm.payment.vo.PaySaveVO;
import com.myspring.lmm.payment.vo.PaymentVO;


@Repository("paymentDAO")
public class PaymentDAOImpl implements PaymentDAO {
	@Autowired
	private SqlSession sqlSession;
	MemberVO memberVO;
	CuponVO cuponVO;

	@Override
	public List selectAllPaymentList(String stoId) throws DataAccessException {
		List<PaymentVO> paymentsList = null;
		paymentsList = sqlSession.selectList("mapper.payment.selectAllPaymentList",stoId);
		return paymentsList;
	}

	@Override
	public int deletePayment(int payNum) throws DataAccessException {
		int result = sqlSession.delete("mapper.payment.deletePayment", payNum);
		return result;
	}

	@Override
	public MemberVO selectCusid(String selectCusIdChild) {
		
		memberVO = sqlSession.selectOne("mapper.member.selectCusid", selectCusIdChild);
		return memberVO;
	}
	
	@Override
	public int selectLastPayNum() {
		int payNum = 0;
		if(sqlSession.selectOne("mapper.payment.selectLastPayNum") == null) {
			payNum = 0;
		}
		else {
			payNum = sqlSession.selectOne("mapper.payment.selectLastPayNum");
		}
		System.out.println("DAO payNum:"+payNum);
		return payNum;
	}

	@Override
	public List SelectcupNumByCusId(String selectCusIdChild) {
		
		List<CuponVO> cuponList = null;
		cuponList = sqlSession.selectList("mapper.cupon.SelectNupNumByCusId",selectCusIdChild);
		return cuponList;
	}
	@Transactional
	@Override
	public int addPayment(PaySaveVO paysaveVO) {
		int result = sqlSession.insert("mapper.payment.addPayment",paysaveVO);
		return result;
	}

	@Transactional
	@Override
	public int saveMileage(PaySaveVO paysaveVO) {
		int saveMileage = sqlSession.insert("mapper.mileage.saveMileage",paysaveVO);
		return saveMileage;
	}
	@Transactional
	@Override
	public int saveTotMil(PaySaveVO paysaveVO) {
		int saveTotMil = sqlSession.update("mapper.member.saveTotMil",paysaveVO);
		return saveTotMil;
	}
	@Transactional
	@Override
	public int cuponTypeChange(PaySaveVO paysaveVO) {
		int cuponTypeChange = sqlSession.update("mapper.cupon.cuponTypeChange",paysaveVO);
		return 0;
	}

	@Override
	public void removeMileage(int payNum) {
		sqlSession.update("mapper.mileage.removeMileage",payNum);
	}

	@Override
	public void refundCuponTypeChange(int cupId) {
		sqlSession.update("mapper.cupon.refundCuponTypeChange",cupId);
	}

	@Override
	public void refundCusTotMil(PaymentVO paymentVO) {
		System.out.println("DAO cusId:"+paymentVO.getCusId());
		System.out.println("DAO milStack:"+paymentVO.getMilStack());
		System.out.println("DAO payUseMil:"+paymentVO.getPayUseMil());
		sqlSession.update("mapper.member.refundCusTotMil", paymentVO);
	}
	

}
