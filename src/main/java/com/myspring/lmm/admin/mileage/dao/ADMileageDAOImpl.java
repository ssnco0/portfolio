package com.myspring.lmm.admin.mileage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.lmm.admin.member.vo.ADMemberVO;

@Repository("ADmileageDAO")
public class ADMileageDAOImpl implements ADMileageDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllMileage() throws DataAccessException {
		List MileageList = null;
		MileageList = sqlSession.selectList("mapper.admin.mileage.selectAllMileage");
		return MileageList;
	}

	@Override
	public List SelectMilById(String cusid, int select) {
		List MileageList = null;
		System.out.println("stoid dao:"+cusid);
		System.out.println("select dao:"+select);
			
		// 아이디값 입력없이 쿼리
		if (cusid == null || cusid.isEmpty()) {
			//아이디값 미입력 적립 마일리지 전체 조회
			if (select == 0) {MileageList = sqlSession.selectList("mapper.admin.mileage.selectAllMileage");	}
			//아이디값 미입력 사용 마일리지 전체 조회
			else {MileageList = sqlSession.selectList("mapper.admin.mileage.selectAllUseMileage");}
		} else {
			if (select == 0) {
				MileageList = sqlSession.selectList("mapper.admin.mileage.selectMileageBycusid", cusid);
			} 
			else {
				MileageList = sqlSession.selectList("mapper.admin.mileage.selectUseMileageBycusid", cusid);
			}
		}
		return MileageList;
	}

	@Override
	public List SelectAllStoreMileage() {
		List StoremileageList = sqlSession.selectList("mapper.admin.mileage.SelectAllStoreMileage");
		return StoremileageList;
	}

	@Override
	public List StoMileageById(String search,int select) {
		List StoremileageList = null;
		System.out.println("search dao:"+search);
		System.out.println("select dao:"+select);
		
		if(search == null || search.isEmpty()) {
			StoremileageList = sqlSession.selectList("mapper.admin.mileage.SelectAllStoreMileage");
		}else {
			if(select == 0) {
				StoremileageList = sqlSession.selectList("mapper.admin.mileage.StoMileageById",search);
			}
			else if(select == 1) {
				StoremileageList = sqlSession.selectList("mapper.admin.mileage.StoMileageByName",search);
			}
			else {
				StoremileageList = sqlSession.selectList("mapper.admin.mileage.StoMileageByLocNum",search);
			}
		}
		return StoremileageList;
	}
	
}
