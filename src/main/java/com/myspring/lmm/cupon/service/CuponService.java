package com.myspring.lmm.cupon.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.lmm.cupon.vo.CuponVO;
import com.myspring.lmm.member.vo.MemberVO;


public interface CuponService {
	 public List listCupons(String stoId) throws DataAccessException;

	 public int addCupon(CuponVO cuponVO) throws DataAccessException;

	 public List listCupons2(CuponVO cuponVO) throws DataAccessException;

	 public List cuscuponList(String stoId) throws DataAccessException;

	 
	 //Å×½ºÆ®
	 public List<MemberVO> listCupons4() throws DataAccessException;
	 
}
