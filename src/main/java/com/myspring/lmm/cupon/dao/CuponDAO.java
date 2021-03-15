package com.myspring.lmm.cupon.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.lmm.cupon.vo.CuponVO;
import com.myspring.lmm.member.vo.MemberVO;


public interface CuponDAO {
    //���� ��ȸ
    public List selectAllCuponList(String stoId) throws DataAccessException;
    public List<CuponVO> selectCusCuponList(String cusId) throws DataAccessException;
	 
    public int insertCupon(CuponVO cuponVO) throws DataAccessException ;
    
    public List<CuponVO> selectTransCuponList(CuponVO cuponVO) throws DataAccessException;
    
    //�׽�Ʈ
    public List<MemberVO> selectAllCuponList4() throws DataAccessException;


}
