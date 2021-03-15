package com.myspring.lmm.admin.cupon.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.lmm.admin.member.vo.ADMemberVO;

public interface ADCuponDAO {

	public List SelectNoAppCupon() throws DataAccessException;

	public void StoreCuponApp(String cupid);

	public List SearchCuponByCupQRNo(String search, int select);

	public List SearchUseCupon(String search, int select);

}
