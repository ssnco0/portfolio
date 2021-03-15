package com.myspring.lmm.mileage.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;


public interface MileageDAO {
//	 public List selectAllMileageList() throws DataAccessException;

//	List selectAllMileage() throws DataAccessException;

    public List selectUseMileage(String cusId) throws DataAccessException;
    public List selectStackMileage(String cusId) throws DataAccessException;


}
