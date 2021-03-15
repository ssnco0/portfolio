package com.myspring.lmm.payment.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.lmm.cupon.vo.CuponVO;
import com.myspring.lmm.member.vo.MemberVO;
import com.myspring.lmm.payment.vo.PaySaveVO;
import com.myspring.lmm.payment.vo.PaymentVO;


public interface PaymentDAO {
	 public List selectAllPaymentList(String stoId) throws DataAccessException;
	 public int deletePayment(int payNum) throws DataAccessException;
	 public MemberVO selectCusid(String selectCusIdChild);
	 public List SelectcupNumByCusId(String selectCusIdChild);
	 public int addPayment(PaySaveVO paysaveVO);
	 public int selectLastPayNum();
	 public int saveMileage(PaySaveVO paysaveVO);
	 public int saveTotMil(PaySaveVO paysaveVO);
	 public int cuponTypeChange(PaySaveVO paysaveVO);
	 public void removeMileage(int payNum);
	 public void refundCuponTypeChange(int cupId);
	 public void refundCusTotMil(PaymentVO paymentVO);
	 
}
