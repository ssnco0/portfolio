package com.myspring.lmm.cupon.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.lmm.cupon.vo.CuponVO;
import com.myspring.lmm.member.vo.MemberVO;

@Repository("cuponDAO")
public class CuponDAOImpl implements CuponDAO {
	@Autowired
	private SqlSession sqlSession;

	
	
	@Override
	public List<CuponVO> selectAllCuponList(String stoId) throws DataAccessException {
		List<CuponVO> cuponsList = null;
		cuponsList = sqlSession.selectList("mapper.cupon.selectAllCuponList",stoId);
		return cuponsList;
	}
	@Override
	public List<CuponVO> selectCusCuponList(String cusId) throws DataAccessException {
		List<CuponVO> cuscuponList = null;
		cuscuponList = sqlSession.selectList("mapper.cupon.selectCusCuponList",cusId);
		return cuscuponList;
	}
	
	@Override
	public List selectTransCuponList(CuponVO cuponVO) throws DataAccessException {
		List<CuponVO> cuponsList2 = null;
		cuponsList2 = sqlSession.selectList("mapper.cupon.selectTransCuponList",cuponVO);
		return cuponsList2;
	}

	@Override
	public int insertCupon(CuponVO cuponVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.cupon.insertCupon", cuponVO);
		return result;
	}
	
	
	
	//Å×½ºÆ®
	@Override
	public List<MemberVO> selectAllCuponList4() throws DataAccessException {
		List<MemberVO> cuponsList4 = null;
		cuponsList4 = sqlSession.selectList("mapper.member.selectAllCuponList4");
		return cuponsList4;
	}
}
