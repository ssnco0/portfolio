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
			
		// ���̵� �Է¾��� ����
		if (cusid == null || cusid.isEmpty()) {
			//���̵� ���Է� ���� ���ϸ��� ��ü ��ȸ
			if (select == 0) {MileageList = sqlSession.selectList("mapper.admin.mileage.selectAllMileage");	}
			//���̵� ���Է� ��� ���ϸ��� ��ü ��ȸ
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
