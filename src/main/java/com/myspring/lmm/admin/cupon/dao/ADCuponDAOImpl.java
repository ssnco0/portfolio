package com.myspring.lmm.admin.cupon.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.lmm.admin.member.vo.ADMemberVO;

@Repository("ADcuponDAO")
public class ADCuponDAOImpl implements ADCuponDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List SelectNoAppCupon() throws DataAccessException {
		List cuponList = sqlSession.selectList("mapper.admin.cupon.SelectAllCupon");
		return cuponList;
	}

	@Override
	public void StoreCuponApp(String cupid) {
		sqlSession.update("mapper.admin.cupon.StoreCuponApp", cupid);
	}

	@Override
	public List SearchCuponByCupQRNo(String search, int select) {
		List cuponList = null;
		
		// 아이디값 입력없이 쿼리
		if (search == null || search.isEmpty()) {
			// 아이디값 미입력 쿠폰 전체 조회
			if (select == 0) {
				cuponList = sqlSession.selectList("mapper.admin.cupon.SelectAllCupon");
			}
			// 아이디값 미입력 승인 쿠폰 조회
			else if(select == 1) {
				cuponList = sqlSession.selectList("mapper.admin.cupon.SelectYesAppCupon");
			}
			// 아이디값 미입력 비승인 쿠폰 조회
			else {
				cuponList = sqlSession.selectList("mapper.admin.cupon.SelectNoAppCupon");
			}
		} else {
			if (select == 0) {
				cuponList = sqlSession.selectList("mapper.admin.cupon.SelectCupByCupNum",search);
			}
			else if(select == 1) {
				cuponList = sqlSession.selectList("mapper.admin.cupon.SelectYesAppCupByCupNum",search);	
			}		
			else {
				cuponList = sqlSession.selectList("mapper.admin.cupon.SelectNoAppCupByCupNum",search);
			}
		}
		return cuponList;
	}

	@Override
	public List SearchUseCupon(String search, int select) {
		List cuponList = null;
		System.out.println("search dao:" + search);
		System.out.println("select dao:" + select);
		
		if(search.equals("0") || search.isEmpty()) {
			if(select == 0) {
				cuponList = sqlSession.selectList("mapper.admin.cupon.SelectAllNotUseCupon");
			}
			else {
				cuponList = sqlSession.selectList("mapper.admin.cupon.SelectAllYesUseCupon");
			}
		}
		else {
			if(select == 0) {
				cuponList = sqlSession.selectList("mapper.admin.cupon.SelectNotUseCuponById",search);
			}
			else {
				cuponList = sqlSession.selectList("mapper.admin.cupon.SelectUseCuponById",search);
			}
		}
		return cuponList;
	}

}
