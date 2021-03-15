package com.myspring.lmm.payment.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.lmm.cupon.vo.CuponVO;
import com.myspring.lmm.member.vo.MemberVO;
import com.myspring.lmm.payment.dao.PaymentDAO;
import com.myspring.lmm.payment.vo.PaySaveVO;
import com.myspring.lmm.payment.vo.PaymentVO;



@Service("paymentService")
@Transactional(propagation = Propagation.REQUIRED)
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentDAO paymentDAO;
	MemberVO memberVO;

	@Override
	public List listPayments(String stoId) throws DataAccessException {
		List paymentsList = null;
		paymentsList = paymentDAO.selectAllPaymentList(stoId);
		return paymentsList;
	}

	@Override
	public int addPayment(PaySaveVO paysaveVO) throws DataAccessException {
		return paymentDAO.addPayment(paysaveVO);
	}

	@Override
	public int removePayment(int payNum) throws DataAccessException {
		return paymentDAO.deletePayment(payNum);
	}

	@Override
	public MemberVO selectCusid(String selectCusIdChild) {
	
		memberVO = paymentDAO.selectCusid(selectCusIdChild);	
		return memberVO;
	}

	@Override
	public List SelectcupNumByCusId(String selectCusIdChild) {
		
		List cuponList = paymentDAO.SelectcupNumByCusId(selectCusIdChild);
		return cuponList;
	}

	@Override
	public int selectLastPayNum() {
		int payNum = paymentDAO.selectLastPayNum();
		return payNum;
	}

	@Override
	public int saveMileage(PaySaveVO paysaveVO) {
		int saveMileage = paymentDAO.saveMileage(paysaveVO);
		return 0;
	}

	@Override
	public int saveTotMil(PaySaveVO paysaveVO) {
		int saveTotMil = paymentDAO.saveTotMil(paysaveVO);
		return saveTotMil;
	}

	@Override
	public int cuponTypeChange(PaySaveVO paysaveVO) {
		int cuponTypeChange = paymentDAO.cuponTypeChange(paysaveVO);
		return cuponTypeChange;
	}

	@Override
	public void removeMileage(int payNum) {
		paymentDAO.removeMileage(payNum);
	}

	@Override
	public void refundCuponTypeChange(int cupId) {
		paymentDAO.refundCuponTypeChange(cupId);
	}

	@Override
	public void refundCusTotMil(PaymentVO paymentVO) {
		paymentDAO.refundCusTotMil(paymentVO);
		
	}

}

