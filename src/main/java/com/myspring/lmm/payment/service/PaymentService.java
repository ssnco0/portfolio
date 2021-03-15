package com.myspring.lmm.payment.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.lmm.cupon.vo.CuponVO;
import com.myspring.lmm.member.vo.MemberVO;
import com.myspring.lmm.payment.vo.PaySaveVO;
import com.myspring.lmm.payment.vo.PaymentVO;

public interface PaymentService {
	 public List listPayments(String stoId) throws DataAccessException;
	 public int addPayment(PaySaveVO paysaveVO) throws DataAccessException;
	 public int removePayment(int payNum) throws DataAccessException;
	 public MemberVO selectCusid(String selectCusIdChild);
	 public List SelectcupNumByCusId(String selectCusIdChild);
	 public int selectLastPayNum();
	 public int saveMileage(PaySaveVO paysaveVO);
	 public int saveTotMil(PaySaveVO paysaveVO);
	 public int cuponTypeChange(PaySaveVO paysaveVO);
	 public void removeMileage(int payNum);
	 public void refundCuponTypeChange(int cupId);
	 public void refundCusTotMil(PaymentVO paymentVO);
	 
}
